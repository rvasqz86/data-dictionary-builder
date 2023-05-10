package com.rvasqz86.datadictionary.demo.entity.meta.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode
public class Column  {
    private String tableSchema;
    private String tableName;
    private String columnName;
    private String dataType;
    private String isNullable;
    private String defaultValue;
    private boolean primaryKey = false;
    private List<Table> relatedTo;
    private String description;

}
