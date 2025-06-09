package br.com.kg.buscafipe.buscafipe.model.modelosResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.kg.buscafipe.buscafipe.model.dados.Dados;


@JsonIgnoreProperties(ignoreUnknown = true)
public record ModeloResponse(
                                @JsonAlias("modelos") List<Dados> dados
                            ) {}
