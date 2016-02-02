package com.reversegroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ReverseGroup
 * https://www.codeeval.com/open_challenges/71/
 * Takes file as an input and every line is new case.
 * Line ; 1,2,3,4,5;2
 * Before ; is the elements which we have to rearrange by reversing sub groups of 2.
 * i.e. the value after ;
 * So, that the output comes as : 
 * 2,1,4,3,5
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/25/2015 1:40AM
 */
public class ReverseGroup {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				String str[] = line.split(";");
				String str1[] = str[0].split(",");
				int groupCount = Integer.parseInt(str[1]);
				for (int i = 0; i < str1.length - (str1.length % groupCount); i += groupCount) {
					if ((str1.length - i) >= groupCount) {
						for (int j = i, k = i + groupCount - 1; j < i + groupCount/2; j++, k--) {
							String temp = str1[j];
							str1[j] = str1[k];
							str1[k] = temp;
						}
					}
				}
				for (int i = 0 ; i < str1.length ; i++) {
					if(i < str1.length - 1) {
						System.out.print(str1[i]+",");
					} else {
						System.out.print(str1[i]);
					}
				}
			}
			System.out.println();
		}
		buffer.close();
	}

}