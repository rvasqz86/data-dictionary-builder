package com.rvasqz86.datadictionary.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rvasqz86.datadictionary.demo.entity.builder.MarkdownBuilder;
import com.rvasqz86.datadictionary.demo.entity.dao.Connect;
import com.rvasqz86.datadictionary.demo.entity.meta.pojo.Column;
import com.rvasqz86.datadictionary.demo.entity.meta.pojo.ForeignKey;
import com.rvasqz86.datadictionary.demo.entity.meta.Mapper;
import com.rvasqz86.datadictionary.demo.entity.meta.pojo.PrimaryKey;
import com.rvasqz86.datadictionary.demo.entity.meta.pojo.Table;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

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

import static com.rvasqz86.datadictionary.demo.WriterUtils.pad;
import static com.rvasqz86.datadictionary.demo.entity.Queries.SELECT_ALL_COLUMNS_SQL;
import static com.rvasqz86.datadictionary.demo.entity.Queries.SELECT_ALL_FOREIGN_KEYS_SQL;
import static com.rvasqz86.datadictionary.demo.entity.Queries.SELECT_ALL_PRIMARY_KEYS_SQL;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DemoApplication {

	@Value("${database}")
	private String server;
	@Value("${user}")
	private String user;
	@Value("${password}")
	private String password;
	@Value("${port}")
	private int port;


	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		extract();
	}

	static void extract() {
		Connect connect = new Connect("", 5432, "postgres", "");
		ResultSet columnsResultSet = connect.execute(SELECT_ALL_COLUMNS_SQL);
		ResultSet primaryKeyResultSet = connect.execute(SELECT_ALL_PRIMARY_KEYS_SQL);
		ResultSet foreignKeyResultSet = connect.execute(SELECT_ALL_FOREIGN_KEYS_SQL);
		Set<Column> columns = new HashSet<>(new Mapper<Column>(new ObjectMapper()).map(columnsResultSet, Column.class));
		List<PrimaryKey> pks = new Mapper<PrimaryKey>(new ObjectMapper()).map(primaryKeyResultSet, PrimaryKey.class);
		List<ForeignKey> fks = new Mapper<ForeignKey>(new ObjectMapper()).map(foreignKeyResultSet, ForeignKey.class);
		Set<Table> tables = columns.stream().map(Column::getTableName).map(Table::new).collect(Collectors.toSet());
		for(Table table: tables) {
			table.setColumns(columns.stream().filter(column -> column.getTableName().equals(table.getTableName())).collect(Collectors.toList()));
		}
		for(PrimaryKey pk: pks) {
			for(Table table: tables) {
				if(table.getTableName().equalsIgnoreCase(pk.getTableName())) {
					List<Column> cols = table.getColumns();
					for(Column column: cols) {
						if(column.getColumnName().equalsIgnoreCase(pk.getKeyColumns())) {
							column.setPrimaryKey(true);
						}
					}
				}
			}
		}
		for(ForeignKey fk: fks) {
			String pTable = fk.getPrimaryTable();
			String fTable = fk.getForeignTable();
			if(pTable.contains(".")) {
				pTable = pTable.split("\\.")[1];
				fTable = fTable.split("\\.")[1];
			}
			String finalPTable = pTable;
			String finalFtable = fTable;
			Table primaryTable = tables.stream().filter(table->table.getTableName().equalsIgnoreCase(finalPTable)).findFirst().orElseThrow();
			Table foreignTable = tables.stream().filter(table->table.getTableName().equalsIgnoreCase(finalFtable)).findFirst().orElseThrow();
			Set<String> primaryRelatedTables = new HashSet<>();
			if(primaryTable.getRelatedTables() != null) {
				primaryRelatedTables.addAll(primaryTable.getRelatedTables());
			}
			primaryRelatedTables.add(foreignTable.getTableName());
			primaryTable.setRelatedTables(primaryRelatedTables.stream().toList());
		}

		MarkdownBuilder markdownBuilder = new MarkdownBuilder();

		try {
			FileWriter myWriter = new FileWriter("out.md");
			myWriter.write(markdownBuilder.build(new ArrayList<>(tables)));
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
