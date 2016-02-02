package com.palindrome;

public class Palindrome {

	public static int reverse(int number) {
		int result = 0;
		while (number > 0) {
			result = result * 10 + (number % 10);
			number = number / 10;
		}
		return result;
	}

	public static void main(String[] args) {
		for (int i = 1000 ; i >= 0; i--) {
			if (i == reverse(i)) {
				boolean flag = true;
				for(int j = 2 ; j < i ; j++) {
					if (i % j == 0) {
						flag = false;
					}
				}
				if (flag) {
					System.out.println(i);
					System.exit(0);
				}
			}
		}
	}
}