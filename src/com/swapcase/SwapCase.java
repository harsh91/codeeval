package com.swapcase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SwapCase {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while((line = buffer.readLine()) != null) {
			if(!line.trim().equals("")) {
				System.out.println(getSwapCase(line.trim()));
			}
		}
		buffer.close();
	}
	
	public static String getSwapCase(String line) {
		char chars[] = line.toCharArray();
		for(int i = 0 ; i < chars.length ; i++) {
			if(Character.isUpperCase(chars[i])) {
				chars[i] = Character.toLowerCase(chars[i]);
			} else {
				chars[i] = Character.toUpperCase(chars[i]);
			}
		}
		return new String(chars);
	}

}
