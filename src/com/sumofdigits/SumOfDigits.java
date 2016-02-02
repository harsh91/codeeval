package com.sumofdigits;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * SumOfDigits
 * Used for sum of digits in the string for a file.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/11/2015
 */
public class SumOfDigits {

	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = buffer.readLine()) != null) {
				if (!line.trim().equals("")) {
					int numberLine = Integer.parseInt(line.trim());
					int sum = 0;
					while (numberLine > 0) {
						sum += numberLine % 10;
						numberLine /= 10;
					}
					System.out.println(sum);
				}
			}
			buffer.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
