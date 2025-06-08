package br.com.kg.buscafipe.buscafipe.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados {
    
    ObjectMapper mapper = new ObjectMapper();

    public <T> T converteDados(String json, TypeReference<T> typeReference) {

        try {
            return mapper.readValue(json, typeReference);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       
    }
}
