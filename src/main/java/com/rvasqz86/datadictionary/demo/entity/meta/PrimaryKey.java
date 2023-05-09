package com.rvasqz86.datadictionary.demo.entity.meta;

import lombok.Data;

import java.util.List;

@Data
public class PrimaryKey {
    private String tableSchema;
    private String tableName;
    private String constraintName;
    private String keyColumns;
}
