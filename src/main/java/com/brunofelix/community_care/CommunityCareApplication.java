package com.brunofelix.community_care;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Community Care API",
				version = "1.0",
				description = "API for managing community centers and their services"
		)
)
@SpringBootApplication
public class CommunityCareApplication {

	public static void main(String[] args) {

		//Carrega as variáveis de ambiente do arquivo .env
		Dotenv dotenv = Dotenv.load();
        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(CommunityCareApplication.class, args);
	}

}
