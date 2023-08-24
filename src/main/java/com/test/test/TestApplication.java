package com.test.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
public class TestApplication {
	@Value("${spring.datasource.url}")
	private static String databaseUrl;
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		System.out.println("URL de la base de datos: " + databaseUrl);
	}
}
