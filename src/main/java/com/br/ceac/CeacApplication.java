package com.br.ceac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class CeacApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeacApplication.class, args);
	}

}
