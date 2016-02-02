package com.bitpositions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * BitPositions
 * Takes a file as input. A line consists of 3 integers delimited
 * by ',' Example: 86,2,3 According to above example we have to check 2nd and
 * 3rd position of 1st integer decimal value are same or not. If same then we
 * print true else false.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/11/2015
 */
public class BitPositions {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.equals("")) {
				String elements[] = line.split(",");
				if (elements.length == 3) {
					int n = Integer.parseInt(elements[0].trim());
					int p1 = Integer.parseInt(elements[1].trim()) - 1;
					int p2 = Integer.parseInt(elements[2].trim()) - 1;
					if (((n >> p1) & 1) == ((n >> p2) & 1)) {
						System.out.println("true");
					} else {
						System.out.println("false");
					}
				}
			}
		}
		buffer.close();
	}

}
