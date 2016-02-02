package com.minimumcoins;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * MinimumCoins Takes file as an input with each line as different case. We have
 * coins worth 1,3,5 and we have to divide each amount in 1,3,5 as minimum coins
 * are used.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/25/2015 2:00AM
 */
public class MinimumCoins {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				double input = Double.parseDouble(line);
				String s = String.valueOf(Math.floor(Math.floor(input / 5) + Math.floor(input % 5) / 3 + ((input % 5) % 3)));
				System.out.println(s.substring(0, s.length() - 2));
			}
		}
		buffer.close();
	}

}