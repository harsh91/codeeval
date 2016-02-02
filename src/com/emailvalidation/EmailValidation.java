package com.emailvalidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * EmailValidation Validates whether a email is correct or not via regex.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/15/2015 2:32PM
 */
public class EmailValidation {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				line = line.trim();
				Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\.\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$|" +
		                "^\"[_A-Za-z0-9-\\.\\+@]+(\\.[_A-Za-z0-9-]+)*\"@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Matcher match = pattern.matcher(line);
				if (match.find()) {
					System.out.println("true");
				} else {
					System.out.println("false");
				}
			}
		}
		buffer.close();
	}

}
