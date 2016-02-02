package com.sumofintegersfromfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * SumOfIntegersFromFile
 * A file having a number on each line.
 * Sum all the integers line by line.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/11/2015
 *
 */
public class SumOfIntegersFromFile {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		int sum = 0;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.equals("")) {
				sum += Integer.parseInt(line.trim());
			}
		}
		System.out.println(sum);
		buffer.close();
	}

}