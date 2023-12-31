package com.deviro.colours.services.impl;

import org.springframework.stereotype.Component;

import com.deviro.colours.services.BluePrinter;
import com.deviro.colours.services.ColourPrinter;
import com.deviro.colours.services.GreenPrinter;
import com.deviro.colours.services.RedPrinter;

@Component
public class ColourPrinterImpl implements ColourPrinter {
	
	private RedPrinter redPrinter;
	private GreenPrinter greenPrinter;
	private BluePrinter bluePrinter;
	
	public ColourPrinterImpl(RedPrinter redPrinter, GreenPrinter GreenPrinter, BluePrinter BluePrinter ) {
		this.redPrinter = redPrinter;
		this.greenPrinter = GreenPrinter;
		this.bluePrinter = BluePrinter;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return String.join(redPrinter.print(), greenPrinter.print(), bluePrinter.Print());
	}

}
