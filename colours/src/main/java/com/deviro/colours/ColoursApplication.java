package com.deviro.colours;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.deviro.colours.services.ColourPrinter;
import com.deviro.colours.services.impl.ColourPrinterImpl;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Log
public class ColoursApplication implements CommandLineRunner {
	
	private ColourPrinter colourPrinter;
	
	public ColoursApplication(ColourPrinter colourPrinter) {
		this.colourPrinter = colourPrinter;
	}

	public static void main(String[] args) {
		SpringApplication.run(ColoursApplication.class, args);
	}

	@Override
	public void run(final String... args){
		log.info(colourPrinter.print());
		
	}
	
	

}
