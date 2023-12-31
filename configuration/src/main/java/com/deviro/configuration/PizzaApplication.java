package com.deviro.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deviro.configuration.config.PizzaConfig;

import lombok.extern.java.Log;

@SpringBootApplication
@Log
public class PizzaApplication implements CommandLineRunner {
	
	private PizzaConfig pizzaConfig;
	
	public PizzaApplication(PizzaConfig pizzaConfig) {
		this.pizzaConfig = pizzaConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//final PizzaConfig pizzaConfig = new PizzaConfig("tomato", "mozarella", "thin");
		
		log.info(
				String.format(
						"I want a %s crust pizza, with %s and %s sauce"
						, pizzaConfig.getCrust(),pizzaConfig.getTopping(), pizzaConfig.getSauce())
				);
		
	}

}
