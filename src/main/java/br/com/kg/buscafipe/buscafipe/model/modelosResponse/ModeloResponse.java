package br.com.kg.buscafipe.buscafipe.model.modelosResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.kg.buscafipe.buscafipe.model.anos.Ano;
import br.com.kg.buscafipe.buscafipe.model.modelos.Modelo;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloResponse(
                                @JsonAlias("modelos") List<Modelo> modelos,
                                @JsonAlias("anos") List<Ano> anos
                            ) {}
