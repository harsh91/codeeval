package com.maxrangesum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Kadane's Algorithm for maximum sub array in linear time.
 * 
 * @author Harsh
 *
 */
public class KadaneAlgoImp {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String input = null;
		while ((input = buffer.readLine()) != null) {
			if (!input.trim().equals("")) {
				String inputss[] = input.trim().split(";");
				String inputs[] = inputss[1].trim().split(" ");
				int groupCount = Integer.parseInt(inputss[0]);
				int curSum = 0;
				for (int i = 0; i < groupCount; i++) {
					curSum += Integer.parseInt(inputs[i]);
				}
				int maxSum = curSum;
				for (int j = 1; j <= inputs.length - groupCount; j++) {
					curSum = curSum - Integer.parseInt(inputs[j - 1]) + Integer.parseInt(inputs[j + groupCount - 1]);

					if (curSum > maxSum) {
						maxSum = curSum;
					}
				}
				if(maxSum > 0) {
					System.out.println(maxSum);
				} else {
					System.out.println(0);
				}
			}
		}
		buffer.close();
	}

}
