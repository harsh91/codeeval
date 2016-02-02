package com.capitalizewords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * CapitalizeWords
 * Makes first character of each word capital.
 * 
 * @author Harsh<girdharharsh01@gmail.com>
 * @since 09/21/2015 2:57AM
 *
 */
public class CapitalizeWords {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				String input[] = line.trim().split(" ");
				String finalStr = "";
				for(int i = 0 ; i < input.length ; i++) {
					finalStr += Character.toUpperCase(input[i].charAt(0)) + input[i].substring(1) + " ";
				}
				System.out.println(finalStr.trim());
			}
		}
		buffer.close();
	}

}
