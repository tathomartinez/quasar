package com.ilem.quasar.quasarilem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
	"quasarilem"})
public class QuasarIlemApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuasarIlemApplication.class, args);
	}

}
