package com.decimaltobinary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DecimalToBinary {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while((line = buffer.readLine()) != null) {
			if(!line.trim().equals("")) {
				System.out.println(decimalToBinary(line));
			}
		}
		buffer.close();
	}

	private static String decimalToBinary(String ins) {
		Integer input = Integer.parseInt(ins);
		if (input == 0) {
	           return "0";
	       }
	       String binary = "";
	       while (input > 0) {
	           int remainder = input % 2;
	           binary = remainder + binary;
	           input = input / 2;
	       }
	       return binary;
	}

}
