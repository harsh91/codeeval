package com.lowercase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * LowerCase
 * Allows us to make full text file lower case taking input line by line.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/10/2015
 *
 */
public class LowerCase {

	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader buffer = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = buffer.readLine()) != null) {
				if (!line.trim().equals("")) {
					System.out.println(line.trim().toLowerCase());
				}
			}
			buffer.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
