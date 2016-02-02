package com.trailingstring;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * TrailingString
 * Used for matching trailing substring with a string.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/11/2015
 */
public class TrailingString {

	public static void main(String[] args) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
			String line = null;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				if (!line.equals("")) {
					String arr[] = line.split(",");
					if (arr.length == 2) {
						arr[0] = arr[0].trim();
						arr[1] = arr[1].trim();
						if(arr[0].endsWith(arr[1])) {
							System.out.println(1);
						} else {
							System.out.println(0);
						}
					}
				}
			}
			buffer.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
