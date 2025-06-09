package br.com.kg.buscafipe.buscafipe.model.dados;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(
                        @JsonAlias("codigo") Integer codigo,
                        @JsonAlias("nome") String nome
                    ) {}
