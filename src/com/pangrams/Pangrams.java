package com.pangrams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException; 

public class Pangrams {
    public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while((line = buffer.readLine()) != null) {
			System.out.println(pangram(line));
		}
		buffer.close();
    }

	private static String pangram(String line) {
		String result = "";
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		int length = alphabets.length();
		for (int counter = 0; counter < length; counter++) {
			String alphabet = alphabets.charAt(counter) + "";
			if (!line.contains(alphabet)) {
				result += alphabet; 
			}
		}
		if(result.isEmpty()) {
			return "NULL";
		}
		return result;
	}
}