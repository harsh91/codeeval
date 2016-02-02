package com.arrayabsurdity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayAbsurdity {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while((line = buffer.readLine()) != null) {
			if(!line.trim().equals("")) {
				System.out.println(getAbsurdity(line));
			}
		}
		buffer.close();
	}
	
	public static String getAbsurdity(String input) {
		String finalStr = "";
		String in[] = input.split(";");
		String ins[] = in[1].split(",");
		ArrayList<String> list = new ArrayList<String>();
		for(String i : ins) {
			if(list.contains(i)) {
				return i;
			} else {
				list.add(i);
			}
		}
		return finalStr;
	}

}
