package com.akrem.converter;

import jdk.jfr.Unsigned;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class MapperUtils {
    @Autowired
    ModelMapper modelMapper;

    public <T> T convert(Object objectToBeConverted, T convertedObject){
        return modelMapper.map(objectToBeConverted,(Type) convertedObject.getClass());
    }


}
