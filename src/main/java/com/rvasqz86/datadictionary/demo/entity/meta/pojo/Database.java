package com.rvasqz86.datadictionary.demo.entity.meta.pojo;

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
}
