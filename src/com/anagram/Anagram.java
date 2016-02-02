package com.anagram;

public class Anagram {

	public static void main(String[] args) {
		String input = "Harsh";
		String check = "hshra";
		check = check.toLowerCase();
		input = input.toLowerCase();
		char[] inputChar = check.toCharArray();
		boolean flag = true;
		for (char ch : inputChar) {
			int in = input.indexOf(ch);
			if (in != -1) {
				input = input.substring(0, in) + input.substring(in + 1, input.length());
			} else {
				flag = false;
			}
		}
		if (flag && input.isEmpty()) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}
