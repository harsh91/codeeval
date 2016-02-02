package com.multiplicationtable;

/**
 * MultiplicationTable
 * Displays multiplication table for 1 to 12 in some symetrical order.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/14/2015 5:35PM
 */
public class MultiplicationTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 1 ; i <= 12 ; i++) {
			for(int j = 1 ; j <= 12 ; j++) {
				if (j == 1) {
					if (i < 10) {
						System.out.print(" ");
					} else {
						System.out.print("");
					}
				}
				System.out.print(i*j);
				if (i*j != i*12) {
					if (i*(j+1) < 10) {
						System.out.print("   ");
					} else if (i*(j+1) < 100) {
						System.out.print("  ");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}

}