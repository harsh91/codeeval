package com.numberofones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * NumberOfones
 * 
 * @author Harsh <girdharharsh@gmail.com>
 * @since 09/12/2015
 */
public class NumberOfOnes {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.equals("")) {
				String binaryRep = Integer.toBinaryString(Integer.parseInt(line));
				int counter = 0;
				for(int i = 0 ; i < binaryRep.length() ; i++) {
					if(binaryRep.charAt(i) == '1') counter++;
				}
				System.out.println(counter);
			}
		}
		buffer.close();
	}

}
