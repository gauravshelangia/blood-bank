package com.indorse.blood.bank.rest.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = "com.indorse.blood.bank.model")
@ComponentScan(basePackages = "com.indorse.blood.bank.*")
@EnableJpaRepositories(basePackages = "com.indorse.blood.bank.dao.*")
public class BloodBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);
	}

}
