package com.decodenumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * DecodeNumbers
 * 
 * 
 * @author Harsh
 * @since 09/25/2015 2:15AM
 */
public class DecodeNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		int counter = 0;
		while ((line = buffer.readLine()) != null) {
			if (!line.equals("")) {
				String str[] = line.split("");
				for (int i = 1; i <= str.length; i++) {
					for (int j = i; j <= str.length; j++) {
						if (Integer.parseInt(line.substring(i - 1, j)) <= 26) {
							counter++;
						}
					}
				}
			}
			System.out.println(counter);
		}
		buffer.close();
	}

}
