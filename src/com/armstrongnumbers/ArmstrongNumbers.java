package com.armstrongnumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArmstrongNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while((line = buffer.readLine()) != null) {
			if(!line.trim().equals("")) {
				if(isArmstrongNumber(line.trim())) {
					System.out.println("True");
				} else {
					System.out.println("False");
				}
			}
		}
		buffer.close();
	}
	
	public static boolean isArmstrongNumber(String number) {
		String num[] = number.split("");
		int originalNumber = Integer.parseInt(number);
		int newNumber = 0;
		for(int i = 1 ; i < num.length ; i++) {
			newNumber += Math.pow(Double.parseDouble(num[i]), Double.parseDouble(""+(num.length-1)));
		}
		if(newNumber != originalNumber) return false;
		return true;
	}

}
