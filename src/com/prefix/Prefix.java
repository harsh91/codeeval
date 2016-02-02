package com.prefix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Prefix Calculates Prefix expression value. It takes file as input and each
 * line in file is a different prefix expression to solve.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/24/2015 3:52PM
 *
 */
public class Prefix {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				String string = line.trim();
				String str[] = string.split(" ");
				int i = 0;
				string = string.replaceAll(" ", "");
				// Getting the index of first integer in array.
				while (!Character.isDigit(string.charAt(i))) {
					i++;
				}
				String operators[] = new String[i]; // Array of operators.
				String operands[] = new String[str.length - operators.length]; // Array of operands.
				int k = 0;
				for (int j = 0; j < str.length; j++) {
					if (j < i) {
						operators[j] = str[j];
					} else {
						operands[k] = str[j];
						k++;
					}
				}

				int operatorCounter = operators.length - 1; // Decreases when operator is used.
				int operandCounter = 0;

				double tempValue = 0;
				while (operatorCounter >= 0) {
					if (operands.length == 1) {
						tempValue = Double.parseDouble(operands[0]);
						// remove this last element from array.
					} else {
						if (operandCounter == 0) {
							tempValue = Double.parseDouble(operands[operandCounter]);
						}
						tempValue = performOperation(operators[operatorCounter], tempValue,
								Double.parseDouble(operands[operandCounter + 1]));
						operandCounter++;
						operatorCounter--;
					}
				}
				if (tempValue >= 0) {
					System.out.println((int) Math.floor(tempValue));
				}
			}
		}
		buffer.close();
	}

	private static double performOperation(String operator, double operand1, double operand2) {
		switch (operator) {
		case "*":
			return operand1 * operand2;
		case "+":
			return operand1 + operand2;
		case "/":
			return operand1 / operand2;
		}
		return 0;
	}

}
