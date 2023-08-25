package com.test.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TestApplication {

	public static void main(String[] args) {
		System.out.println("INICIALIZANDO SISTEMA======================");
		SpringApplication.run(TestApplication.class, args);
	}
}
