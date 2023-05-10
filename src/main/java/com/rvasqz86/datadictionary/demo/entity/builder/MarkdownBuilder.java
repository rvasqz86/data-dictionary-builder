package com.rvasqz86.datadictionary.demo.entity.builder;

import com.rvasqz86.datadictionary.demo.entity.meta.pojo.Column;
import com.rvasqz86.datadictionary.demo.entity.meta.pojo.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.rvasqz86.datadictionary.demo.WriterUtils.pad;

public class MarkdownBuilder {
    public static String FILE_EXT = "md";
    public String build(List<Table> tables) {
        StringBuilder builder = new StringBuilder();
        builder.append("## Tables\n");


        for(int i = 0; i < tables.size();i++) {
            Table table = tables.get(i);
            builder.append(String.format("%s. [%s](#%s)\n", i+1, table.getTableName(), table.getTableName()));
        }

        String tableHeaderForColumns = String.format("|%s|%s|%s|%s\n",
                pad("Column Name",16),
                pad("Data Type",16),
                pad("Primary Key", 16),
                pad("Description",16));

        String tableHeaderForRelated = String.format("|%s| \n",
                pad("Related Tables",16));

        String tableDividerForColumns = String.format("|%s|%s|%s|%s|\n",
                pad("",16,"-"),
                pad("",16,"-"), pad("",16,"-"),
                pad("",16,"-"));

        String tableDividerForRelated = String.format("|%s|\n",
                pad("",16,"-"));

        builder.append("\n\n");

        for(Table table: tables) {
            builder.append(String.format("## %s\n\n", table.getTableName()));

            builder.append("\n");
            builder.append(String.format("*%s*\n\n", "Add a description"));

            builder.append(tableHeaderForRelated);
            builder.append(tableDividerForRelated);
            if(table.getRelatedTables() ==  null) {
                table.setRelatedTables(new ArrayList<>());
            }
            for(String related : table.getRelatedTables()) {
                builder.append(String.format("|%s|\n",pad(related, 16)) );
            }
            builder.append("\n");

            builder.append(tableHeaderForColumns);
            builder.append(tableDividerForColumns);

            for(Column column: table.getColumns()) {
                builder.append(String.format("|%s|%s|%s|%s\n",
                        pad(column.getColumnName(), 16),
                        pad(column.getDataType(), 16),
                        pad(Boolean.toString(column.isPrimaryKey()), 16),
                        pad(column.getDescription(),16)));
            }
        }
        builder.append("\n\n");


        return builder.toString();
    }
}
