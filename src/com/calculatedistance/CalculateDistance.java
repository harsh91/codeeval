package com.calculatedistance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * CalculateDistance
 * Calculates distance between two points using distance formula
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/21/2015 2:45AM
 */
public class CalculateDistance {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				line = line.replace(") (", ",").replaceAll(" ", "").replace(")", "").replace("(", "");
				String inputs[] = line.split(",");
				int inp[] = new int[inputs.length];
				for(int i = 0 ; i < inputs.length ; i++) {
					inp[i] = Integer.parseInt(inputs[i]);
				}
				int distance = (int)Math.sqrt(((inp[2] - inp[0]) * (inp[2] - inp[0])) + (((inp[3] - inp[1]) * (inp[3] - inp[1]))));
				System.out.println(distance);
			}
		}
		buffer.close();
	}

}
