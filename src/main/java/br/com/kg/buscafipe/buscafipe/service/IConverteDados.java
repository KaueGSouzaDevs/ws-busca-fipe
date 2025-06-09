package br.com.kg.buscafipe.buscafipe.service;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IConverteDados {
    
    <T> T converteDados(String json, Class<T> classe);
    
    <T> List<T> converteLista(String json, Class<T> classe);

    <T> T converteDadosDinamico(String json, TypeReference<T> typeReference);
}
