package com.reversewords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReverseWords {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while((line = buffer.readLine()) != null) {
			if(!line.trim().equals("")) {
				String ins[] = line.split(" ");
				System.out.println(reverseWords(ins));
			}
		}
		buffer.close();
	}
	
	public static String reverseWords(String[] s1) {
	    String finalStr = "";
	    for(int i = s1.length-1 ; i >= 0 ; i--) {
	    	finalStr = finalStr + s1[i] + " ";
	    }
		return finalStr.trim();
	}

}
