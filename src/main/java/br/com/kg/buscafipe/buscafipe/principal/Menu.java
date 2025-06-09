package br.com.kg.buscafipe.buscafipe.principal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.com.kg.buscafipe.buscafipe.model.dados.Dados;
import br.com.kg.buscafipe.buscafipe.model.modelosResponse.ModeloResponse;
import br.com.kg.buscafipe.buscafipe.service.BuscarFipe;

public class Menu {
    
    public void menuPrincipal() {

        BuscarFipe buscarFipe = new BuscarFipe();

		Scanner leitura = new Scanner(System.in);


		System.out.println("\n\n---------------------------------------------------------------------------------------------------");
		System.out.println("Bem vindo ao Busca Fipe!");
		System.out.println("---------------------------------------------------------------------------------------------------");

		System.out.println("\n\n---------------------------------------------------------------------------------------------------");
		System.out.println("Escolha uma das Opções: ");
		System.out.println("Carro");
		System.out.println("Moto");
		System.out.println("Caminhão");
		System.out.println("---------------------------------------------------------------------------------------------------");


		String opcao = leitura.nextLine();
		String tipoVeiculo;

		if (opcao.toLowerCase().contains("carr")) {
			tipoVeiculo = "carros";
		} else if (opcao.toLowerCase().contains("oto")) {
			tipoVeiculo = "motos";
		} else if (opcao.toLowerCase().contains("aminh")) {
			tipoVeiculo = "caminhoes";
		} else {
			tipoVeiculo = "carros";
		};


		System.out.println("\n\n---------------------------------------------------------------------------------------------------");
		System.out.println("Buscando marcas...");
		System.out.println("---------------------------------------------------------------------------------------------------");
		buscarFipe.obterMarcas(tipoVeiculo);

		System.out.println("\n\n---------------------------------------------------------------------------------------------------");
		System.out.println("Digite o código da marca desejada: ");
		System.out.println("---------------------------------------------------------------------------------------------------\n");

		String marca = leitura.nextLine();


		System.out.println("\n---------------------------------------------------------------------------------------------------");
		System.out.println("Buscando modelos...");
		System.out.println("---------------------------------------------------------------------------------------------------");
		ModeloResponse modeloResponse = buscarFipe.obterModelos(tipoVeiculo, marca);


		System.out.println("\n\n---------------------------------------------------------------------------------------------------");
		System.out.println("Digite um trecho do modelo desejado: ");
		System.out.println("---------------------------------------------------------------------------------------------------\n");


		String modeloDesejado = leitura.nextLine();

		List<Dados> modelos = new ArrayList<>();

		modeloResponse.dados().stream().filter(modelo -> modelo.nome().toLowerCase().contains(modeloDesejado.toLowerCase())).forEach(modelo -> modelos.add(modelo));


		if (modelos.isEmpty()) {
			System.out.println("Modelo não encontrado. Por favor, procurar pelos códigos exibidos anteriormente.");
		} else {
			modelos.stream().sorted(Comparator.comparing(Dados::codigo)).forEach(modelo -> System.out.println("Código: " + modelo.codigo() + " | Nome: " + modelo.nome()));
		}



		System.out.println("\n\n---------------------------------------------------------------------------------------------------");
		System.out.println("Digite o código do modelo desejado: ");
		System.out.println("---------------------------------------------------------------------------------------------------\n");

		String modelo = leitura.nextLine();

		System.out.println("\n---------------------------------------------------------------------------------------------------");
		System.out.println("Buscando anos...");
		System.out.println("---------------------------------------------------------------------------------------------------");
		buscarFipe.obterAnos(tipoVeiculo, marca, modelo);

		leitura.close();
    }

}
