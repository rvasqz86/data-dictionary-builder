package com.rvasqz86.datadictionary.demo.entity.meta;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class Table {
    private String tableName;
    private List<Column> columns;

    public Table(String tableName) {
        this.tableName = tableName;
    }
}
