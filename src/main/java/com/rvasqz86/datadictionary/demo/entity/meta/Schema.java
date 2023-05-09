package com.rvasqz86.datadictionary.demo.entity.meta;

import lombok.Data;

import java.util.List;

@Data
public class Schema {
    private String schemaName;
    private List<Table> tables;
}
