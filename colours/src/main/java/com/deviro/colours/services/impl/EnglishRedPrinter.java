package com.deviro.colours.services.impl;

import org.springframework.stereotype.Component;

import com.deviro.colours.services.RedPrinter;

@Component
public class EnglishRedPrinter implements RedPrinter {

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "red";
	}

}
