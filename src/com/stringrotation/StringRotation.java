package com.stringrotation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StringRotation {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while((line = buffer.readLine()) != null) {
			if(!line.trim().equals("")) {
				String ins[] = line.split(",");
				if(isRotation(ins[0], ins[1])) {
					System.out.println("True");
				} else {
					System.out.println("False");
				}
			}
		}
		buffer.close();
	}
	
	public static boolean isRotation(String s1,String s2) {
	    return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
	}

}
