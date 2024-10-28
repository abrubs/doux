package br.com.doux.doux_projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.doux.doux_projeto"})
public class DouxProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DouxProjetoApplication.class, args);
	}

}
