package br.com.kg.buscafipe.buscafipe.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import br.com.kg.buscafipe.buscafipe.model.dados.Dados;
import br.com.kg.buscafipe.buscafipe.model.modelosResponse.ModeloResponse;
import br.com.kg.buscafipe.buscafipe.model.veiculoResponse.VeiculoResponse;

public class BuscarFipe {

    private ConsumoApi consumoApi = new ConsumoApi();
    private ConverteDados converteDados = new ConverteDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void obterMarcas(String tipoVeiculo) {

        String apiUrl = URL_BASE + tipoVeiculo.toLowerCase() + "/marcas";

        var json = consumoApi.obterDados(apiUrl);


        List<Dados> dados = converteDados.converteDadosDinamico(json, new TypeReference<List<Dados>>() {});

        dados.stream().sorted(Comparator.comparing(Dados::codigo)).forEach(marca -> System.out.println("Código: " + marca.codigo() + " | Nome: " + marca.nome()));
    };

    public ModeloResponse obterModelos(String tipoVeiculo, String marca) {
        String apiUrl = URL_BASE + tipoVeiculo.toLowerCase() + "/marcas/" + marca + "/modelos";

        var json = consumoApi.obterDados(apiUrl);

        ModeloResponse modeloResponse = converteDados.converteDadosDinamico(json, new TypeReference<ModeloResponse>() {});

        modeloResponse.dados().stream().sorted(Comparator.comparing(Dados::codigo)).forEach(modelo -> System.out.println("Código: " + modelo.codigo() + " | Nome: " + modelo.nome()));

        return modeloResponse;
    }

    public void obterAnos(String tipoVeiculo, String marca, String modelo) {
        String aiUrlpAnos = URL_BASE + tipoVeiculo.toLowerCase() + "/marcas/" + marca + "/modelos/" + modelo + "/anos";

        var jsonAnos = consumoApi.obterDados(aiUrlpAnos);

        List<Dados> dados = converteDados.converteDadosDinamico(jsonAnos, new TypeReference<List<Dados>>() {});

        // anos.stream().sorted(Comparator.comparing(Ano::codigo)).forEach(ano -> System.out.println("Código: " + ano.codigo() + " | Nome: " + ano.nome()));

        List<VeiculoResponse> veiculos = new ArrayList<>();

        dados.forEach(ano -> {
            var aiUrlpVeiculo = URL_BASE + tipoVeiculo.toLowerCase() + "/marcas/" + marca + "/modelos/" + modelo + "/anos/" + ano.codigo();
            var jsonVeiculo = consumoApi.obterDados(aiUrlpVeiculo);
            veiculos.add(converteDados.converteDadosDinamico(jsonVeiculo, new TypeReference<VeiculoResponse>() {}));
        });

        veiculos.stream().sorted(Comparator.comparing(VeiculoResponse::anoModelo)).forEach(veiculo -> System.out.println("Modelo: " + veiculo.marca() + " " + veiculo.modelo() + "   |   Ano: " + veiculo.anoModelo() + "   |   Valor na Fipe: " + veiculo.valor() + "   |   Combustível: " + veiculo.combustivel() + "   |   Mês de Referência: " + veiculo.mesReferencia()));

    }
}
