package com.deviro.colours.services.impl;

import org.springframework.stereotype.Component;

import com.deviro.colours.services.BluePrinter;

@Component
public class EnglishBluePrinter implements BluePrinter {

	@Override
	public String Print() {
		// TODO Auto-generated method stub
		return "blue";
	}

}
