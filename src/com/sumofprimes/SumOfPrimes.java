package com.sumofprimes;

/**
 * SumOfPrimes
 * Calculates sum of first 1000 prime numbers and displays it.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/14/2015 5:50PM
 */
public class SumOfPrimes {

	private static int counter = 0, sum = 0, prevPrimeNumber = 1;
	public static void main(String[] args) {
		while (counter <= 1000) {
			sum += getNextPrimeNumber();
			counter++;
		}
		System.out.println(sum);
	}
	
	public static int getNextPrimeNumber() {
		boolean flag = true;
		while(flag) {
			// calculate the next prime number after prevPrimeNumber.
		}
		return prevPrimeNumber;
	}

}
