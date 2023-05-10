package com.rvasqz86.datadictionary.demo.entity;

public class Queries {
    public static final String SELECT_ALL_COLUMNS_SQL = "select table_schema as tableSchema,\n" +
        "       table_name as tableName,\n" +
        "       column_name as columnName,\n" +
        "       data_type as dataType,\n" +
        "       is_nullable as isNullable,\n" +
        "       false as primaryKey,\n" +
        "       NULL as relatedTo,\n" +
        "       'Replace me' as description,\n" +
        "       column_default as defaultValue\n" +
        "from information_schema.columns\n" +
        "where table_schema not in ('information_schema', 'pg_catalog')\n" +
        "order by tableSchema, \n" +
        "         tableName;\n";

    public static final String SELECT_ALL_PRIMARY_KEYS_SQL = "select kcu.table_schema as tableSchema,\n" +
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
    public static final String SELECT_ALL_FOREIGN_KEYS_SQL = "select kcu.table_schema || '.' ||kcu.table_name as foreignTable,\n" +
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
}
