package com.rvasqz86.datadictionary.demo.entity.meta;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapper<T>{
    private final ObjectMapper objectMapper;

    public Mapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    public List<T> map(ResultSet resultSet, Class<T> clazz) {
        List<T> result = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> valueMap = new HashMap<>();
        if(resultSet == null) {
            return result;
        }
        while (resultSet.next()) {
            for (Field field : fields) {
                valueMap.put(field.getName(),resultSet.getObject(field.getName()));
            }
            T value = objectMapper.convertValue(valueMap, clazz);
            result.add(value);
        }
        return result;

    }
}
