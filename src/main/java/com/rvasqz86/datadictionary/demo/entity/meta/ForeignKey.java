package com.rvasqz86.datadictionary.demo.entity.meta;

import lombok.Data;

import java.util.List;

@Data
public class ForeignKey {
    private String foreignTable;
    private String primaryTable;
    private String keyColumns;
    private String constraintName;

}
