package com.reverseandadd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReverseAndAdd {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.equals("")) {
				boolean ispalindromeNotFound = true;
				int counter = 0;
				int number = Integer.parseInt(line.trim());
				while(ispalindromeNotFound) {
					counter++;
					int reverseNumber = reverseNumber( number );
					if (isPalindrome( number + reverseNumber )) {
						System.out.println( counter + " " + ( number + reverseNumber ));
						ispalindromeNotFound = false;
					} else {
						number += reverseNumber;
					}
				}
			}
		}
		buffer.close();
	}
	
	public static boolean isPalindrome(int number) {
		String num[] = String.valueOf(number).split("");
		for (int i = 1, j = num.length-1 ; i <= num.length/2 ; i++, j--) {
			if (!num[i].equals(num[j])) {
				return false;
			}
		}
		return true;
	}
	
	public static int reverseNumber(int number) {
		String reverseNumber = "";
		while(number > 0) {
			reverseNumber += number % 10;
			number /= 10;
		}
		return Integer.parseInt(reverseNumber.trim());
	}

}
