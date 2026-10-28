package com.arti.hibernateDemo.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean,String> {
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) {
            return null;
        }
//        if(attribute==true){
//            return "Yes";
//        }
//        return "false";

        return attribute? "Yes":"No";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if(dbData==null){
            return null;
        }
        return dbData.equals("Yes");
    }
}
