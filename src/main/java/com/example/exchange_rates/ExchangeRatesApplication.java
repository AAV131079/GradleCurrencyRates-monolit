package com.example.exchange_rates;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@OpenAPIDefinition(
		info = @Info(
				title = "Exchange rates API.",
				description = "API for obtaining exchange rates using the data of different financial institutions. Created by Java Spring with Gradle.",
				termsOfService = "https://bitbucket.org/java-aav/exchangerates/src/master/",
				contact = @Contact(
						name  = ": Anichkin Oleksandr by email",
						email = "13101979@ukr.net"
				),
				license = @License(
						name = "License: Freeware"
				),
				version = "1.0.1"
		)
)
@SpringBootApplication
@EnableScheduling
public class ExchangeRatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeRatesApplication.class, args);
	}

}