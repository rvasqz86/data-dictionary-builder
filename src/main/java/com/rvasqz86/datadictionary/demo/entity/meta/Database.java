package com.rvasqz86.datadictionary.demo.entity.meta;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class Database{
    private String databaseId;
    private String databaseName;
    private List<Schema> schemas;

    public String query() {
        return "select * from select oid as databaseId,\n" +
                "       datname as databaseName\n" +
                "from pg_database\n" +
                "order by oid ";
    }

}
