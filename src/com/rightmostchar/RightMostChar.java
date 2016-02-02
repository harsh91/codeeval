package com.rightmostchar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

/**
 * RightmostChar
 * Displays the right most occurrence of the character in a string.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/19/2015 12:59AM
 */
public class RightMostChar {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while((line = buffer.readLine()) != null) {
			if (!line.equals("")) {
				String lines[] = line.split(",");
				System.out.println(lines[0].lastIndexOf(lines[1]));
			}
		}
	}

}
