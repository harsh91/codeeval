package com.fibonacciseries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Fibonacci Series
 * Calculate fibonaaci series of a file having number on each line.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/11/2015
 *
 */
public class FibonacciSeries {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.equals("")) {
				String elements[] = line.split(",");
				if (elements.length == 1) {
					int n = Integer.parseInt(elements[0].trim());
					int a = 0, b = 1, sum = 0;
					for(int i = 1 ; i <= n ; i++) {
						sum = a + b;
						a = b;
						b = sum;
					}
					System.out.println(a);
				}
			}
		}
		buffer.close();
	}

}
