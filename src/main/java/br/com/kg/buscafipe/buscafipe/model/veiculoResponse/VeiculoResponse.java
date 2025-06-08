package br.com.kg.buscafipe.buscafipe.model.veiculoResponse;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VeiculoResponse(
                                @JsonAlias("TipoVeiculo") String tipoVeiculo,
                                @JsonAlias("Valor") String valor,
                                @JsonAlias("Marca") String marca,
                                @JsonAlias("Modelo") String modelo,
                                @JsonAlias("AnoModelo") String anoModelo,
                                @JsonAlias("Combustivel") String combustivel,
                                @JsonAlias("CodigoFipe") String codigoFipe,
                                @JsonAlias("MesReferencia") String mesReferencia,
                                @JsonAlias("SiglaCombustivel") String siglaCombustivel
                            ) {}
