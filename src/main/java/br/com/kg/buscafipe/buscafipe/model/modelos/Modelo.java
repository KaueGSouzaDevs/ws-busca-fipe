package br.com.kg.buscafipe.buscafipe.model.modelos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelo(
                        @JsonAlias("codigo") Integer codigo,
                        @JsonAlias("nome") String nome
                    ) {}
