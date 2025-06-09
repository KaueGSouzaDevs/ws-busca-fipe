package br.com.kg.buscafipe.buscafipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.kg.buscafipe.buscafipe.principal.Menu;

@SpringBootApplication
public class BuscafipeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BuscafipeApplication.class, args);
	};


	@Override
	public void run(String... args) throws Exception {

		var nome = "Busca Fipe";
		

		Menu menu = new Menu();
		menu.menuPrincipal();
	}

}
