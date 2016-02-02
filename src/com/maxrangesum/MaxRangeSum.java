package com.maxrangesum;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * MaxRangeSum
 * Calculates the maximum sum possible contiguous for number of integers.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/21/2015 1:50AM
 */
public class MaxRangeSum {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while((line = buffer.readLine()) != null) {
			if(!line.equals("")) {
				String lines[] = line.split(";");
				String inputs[] = lines[1].split(" ");
				int counter = 0;
				int sum[] = new int[inputs.length - Integer.parseInt(lines[0]) + 1];
				int maxSum = 0;
				while(counter < inputs.length - Integer.parseInt(lines[0]) + 1) {
					for(int i = counter ; i < counter+Integer.parseInt(lines[0]) ; i++) {
						sum[counter] += Integer.parseInt(inputs[i]);
					}
					if(maxSum < sum[counter]) {
						maxSum = sum[counter];
					}
					counter++;
				}
				System.out.println(maxSum);
			}
		}
		buffer.close();
	}

}