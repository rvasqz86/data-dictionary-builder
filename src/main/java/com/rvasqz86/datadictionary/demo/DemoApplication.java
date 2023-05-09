package com.rvasqz86.datadictionary.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvasqz86.datadictionary.demo.entity.meta.Column;
import com.rvasqz86.datadictionary.demo.entity.meta.ForeignKey;
import com.rvasqz86.datadictionary.demo.entity.meta.Mapper;
import com.rvasqz86.datadictionary.demo.entity.meta.PrimaryKey;
import com.rvasqz86.datadictionary.demo.entity.meta.Table;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		extract();
	}


	public static  Connection getConnection(String serverName, int portNumber, String user, String password) throws SQLException {
		return DriverManager.getConnection(String.format("jdbc:postgresql://%s:%s/postgres", serverName,portNumber), user, password);
	}

	public static ResultSet execute(String sql) {
		try {
			Connection connection = getConnection("", 5432, "postgres", "");
			Statement statement = connection.createStatement();
			return statement.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String pad(String string, int pad) {
		if(string == null || string.equals("null") ) {
			string = "";
		}
		return StringUtils.leftPad(string, pad *2, " ");
	}
	static void extract() {
		String getAllColumnsQuery = "select table_schema as tableSchema,\n" +
				"       table_name as tableName,\n" +
				"       column_name as columnName,\n" +
				"       data_type as dataType,\n" +
				"       is_nullable as isNullable,\n" +
				"       false as primaryKey,\n" +
				"       NULL as relatedTo,\n" +
				"       NULL as description,\n" +
				"       column_default as defaultValue\n" +
				"from information_schema.columns\n" +
				"where table_schema not in ('information_schema', 'pg_catalog')\n" +
				"order by tableSchema, \n" +
				"         tableName;\n";

		String getAllPrimaryKeys = "select kcu.table_schema as tableSchema,\n" +
				"       kcu.table_name as tableName,\n" +
				"       tco.constraint_name as constraintName,\n" +
				"       kcu.column_name as keyColumns\n" +
				"from information_schema.table_constraints tco\n" +
				"join information_schema.key_column_usage kcu \n" +
				"     on kcu.constraint_name = tco.constraint_name\n" +
				"     and kcu.constraint_schema = tco.constraint_schema\n" +
				"     and kcu.constraint_name = tco.constraint_name\n" +
				"where tco.constraint_type = 'PRIMARY KEY'\n" +
				"order by kcu.table_schema,\n" +
				"         kcu.table_name;";
		String getAllForeignKeys = "select kcu.table_schema || '.' ||kcu.table_name as foreignTable,\n" +
				"       rel_tco.table_schema || '.' || rel_tco.table_name as primaryTable,\n" +
				"       string_agg(kcu.column_name, ', ') as keyColumns,\n" +
				"       kcu.constraint_name as constraintName\n" +
				"from information_schema.table_constraints tco\n" +
				"join information_schema.key_column_usage kcu\n" +
				"          on tco.constraint_schema = kcu.constraint_schema\n" +
				"          and tco.constraint_name = kcu.constraint_name\n" +
				"join information_schema.referential_constraints rco\n" +
				"          on tco.constraint_schema = rco.constraint_schema\n" +
				"          and tco.constraint_name = rco.constraint_name\n" +
				"join information_schema.table_constraints rel_tco\n" +
				"          on rco.unique_constraint_schema = rel_tco.constraint_schema\n" +
				"          and rco.unique_constraint_name = rel_tco.constraint_name\n" +
				"where tco.constraint_type = 'FOREIGN KEY'\n" +
				"group by kcu.table_schema,\n" +
				"         kcu.table_name,\n" +
				"         rel_tco.table_name,\n" +
				"         rel_tco.table_schema,\n" +
				"         kcu.constraint_name\n" +
				"order by kcu.table_schema,\n" +
				"         kcu.table_name;";

		ResultSet columnsResultSet = execute(getAllColumnsQuery);
		ResultSet primaryKeyResultSet = execute(getAllPrimaryKeys);
		ResultSet foreignKeyResultSet = execute(getAllForeignKeys);
		Set<Column> columns = new HashSet<>(new Mapper<Column>(new ObjectMapper()).map(columnsResultSet, Column.class));
		List<PrimaryKey> pks = new Mapper<PrimaryKey>(new ObjectMapper()).map(primaryKeyResultSet, PrimaryKey.class);
		List<ForeignKey> fks = new Mapper<ForeignKey>(new ObjectMapper()).map(foreignKeyResultSet, ForeignKey.class);
		Set<Table> tables = columns.stream().map(Column::getTableName).map(Table::new).collect(Collectors.toSet());

		for(PrimaryKey pk: pks) {
			for(Column column: columns) {
				if(column.getTableName().equals(pk.getTableName()) && pk.getKeyColumns().contains(column.getColumnName())) {
					column.setPrimaryKey(true);
				}
			}
		}
		for(ForeignKey fk: fks) {
			for(Column column: columns) {
				if(column.getTableName().equals(fk.getPrimaryTable()) && fk.getKeyColumns().contains(column.getColumnName()) ||  column.getTableName().equals(fk.getForeignTable())  ) {
					Table related = tables.stream().filter(t-> t.getTableName().equals(column.getTableName())).findFirst().orElseThrow();
					Set<Table> existing = new HashSet<>(Optional.ofNullable(column.getRelatedTo()).orElse(new ArrayList<>()));
					existing.add(related);
					column.setRelatedTo(existing.stream().toList());
				}
			}
		}

		for(Table table: tables) {
			table.setColumns(columns.stream().filter(column -> column.getTableName().equals(table.getTableName())).collect(Collectors.toList()));
		}
		StringBuilder builder = new StringBuilder();
		builder.append("## Tables\n");
		builder.append(String.format("|%s|%s|%s|%s|%s|\n", pad("Table Name",16), pad("Column Name",16), pad("Data Type",16),pad("Related Tables",16), pad("Description",16)));
		builder.append(String.format("|%s|%s|%s|%s|%s|\n", pad("-----------------",16),pad("-----------------",16), pad("-----------------",16),pad("-----------------",16),
				pad("-----------------",16)));
		for(Table table: tables) {
			builder.append(String.format("|%s|%s|%s|%s|%s|\n", pad(table.getTableName(), 16), pad("",16),pad("",16), pad("",16), pad("",16)));
			for(Column column: table.getColumns()) {
				builder.append(String.format("|%s|%s|%s|%s|%s|\n",
						pad("", 16),
						pad(column.getColumnName(), 16),
						pad(column.getDataType(), 16),
						pad(column.getRelatedTo() == null? "" : column.getRelatedTo().stream().map(Table::getTableName).collect(Collectors.joining()), 16),
						pad(column.getDescription(),16)));
			}
		}

		try {
			FileWriter myWriter = new FileWriter("out.md");
			myWriter.write(builder.toString());
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		System.out.println(builder);
	}

}
