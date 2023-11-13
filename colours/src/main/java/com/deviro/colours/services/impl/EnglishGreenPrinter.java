package com.deviro.colours.services.impl;

import org.springframework.stereotype.Component;

import com.deviro.colours.services.GreenPrinter;

@Component
public class EnglishGreenPrinter implements GreenPrinter{

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "green";
	}

}
