package com.evennumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * EvenNumbers
 * Check whether the input provided is even or not. Checking the
 * last character of the input as 0|2|4|6|8. As, division is more costly then
 * this operation. In division case time comes out to be 16k nanoseconds and in
 * case of matching last char it comes out to be 13k.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/21/2015 2:13AM
 */
public class EvenNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				char evenChar = line.trim().charAt(line.length() - 1);
				if (evenChar == '0' || evenChar == '2' || evenChar == '4' || evenChar == '6' || evenChar == '8') {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			}
		}
		buffer.close();
	}

}
