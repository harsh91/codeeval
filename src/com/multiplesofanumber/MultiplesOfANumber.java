package com.multiplesofanumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * MultiplesOfANumber
 * Calculates smallest multiple of n which is greater than or
 * equal to number provided.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/11/2015
 *
 */
public class MultiplesOfANumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.equals("")) {
				String elements[] = line.split(",");
				if (elements.length == 2) {
					int x = Integer.parseInt(elements[0].trim());
					int n = Integer.parseInt(elements[1].trim());
					if (x % n == 0) {
						System.out.println(x);
					} else {
						System.out.println(x - (x % n) + n);
					}
				}
			}
		}
		buffer.close();
	}

}
