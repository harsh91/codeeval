package com.longestword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestWord {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while((line = buffer.readLine()) != null) {
			if(!line.trim().equals("")) {
				String input[] = line.split(" ");
				int curMax = 0;
				String max = "";
				for(int i = 0 ; i < input.length ; i++) {
					if(curMax < input[i].length()) {
						max = input[i];
						curMax = input[i].length();
					}
				}
				System.out.println(max);
			}
		}
		buffer.close();
	}

}
