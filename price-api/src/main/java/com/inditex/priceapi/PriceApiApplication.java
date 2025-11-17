package com.inditex.priceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.inditex.priceapi"})
public class PriceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceApiApplication.class, args);
	}

}
