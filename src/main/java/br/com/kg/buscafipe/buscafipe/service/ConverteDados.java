package br.com.kg.buscafipe.buscafipe.service;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import br.com.kg.buscafipe.buscafipe.model.dados.Dados;

public class ConverteDados implements IConverteDados{
    
    ObjectMapper mapper = new ObjectMapper();

    public <T> T converteDadosDinamico(String json, TypeReference<T> typeReference) {

        try {
            return mapper.readValue(json, typeReference);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
       
    }

    @Override
    public <T> T converteDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> List<T> converteLista(String json, Class<T> classe) {

        CollectionType dados = mapper.getTypeFactory()
                                .constructCollectionType(List.class, Dados.class);

        try {
            return mapper.readValue(json, dados);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
