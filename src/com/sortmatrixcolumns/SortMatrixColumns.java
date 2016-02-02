package com.sortmatrixcolumns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Still working on this one!!
 * 
 * @author Harsh
 *
 */
public class SortMatrixColumns {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while((line = buffer.readLine()) != null) {
			if(!line.trim().equals("")) {
				System.out.println(sortMatrix(line));
			}
		}
		buffer.close();
	}
	
	public static String sortMatrix(String str) {
		String st[] = str.split("|");
		for(int i = 0 ; i < st.length ; i++) {
			st[i] = st[i].trim();
		}
		for(int i = 0 ; i < st.length ; i++) {
			
		}
		return "";
	}

}
