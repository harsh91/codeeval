package com.skyscrapers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * SkyScrapers
 * Outline the given number of buildings.
 * 
 * @author Harsh
 * @since 12/01/2015 12:15AM
 */
public class SkyScrapers {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));

		String line = "";
		// fetching line by line
		while ((line = buffer.readLine()) != null) {
			System.out.println(skyscraper(line).trim());
		}
		buffer.close();
	}
	
	private static String skyscraper(String input) {
		// Initialization part
		int height[] = new int[10001];
		int left, right, buildingHeight;
		String finalStr = "";
		if (!input.trim().equals("")) {
			String inputs[] = input.trim().split(";");
			
			// Outlining building one by one
			for (int i = 0; i < inputs.length; i++) {
				inputs[i] = inputs[i].replace("(", "").replace(")", "");
				String ins[] = inputs[i].split(",");
				
				// Getting building left right and height
				left = Integer.parseInt(ins[0].trim());
				buildingHeight = Integer.parseInt(ins[1].trim());
				right = Integer.parseInt(ins[2].trim());
				
				// Comparing heights at that point and choosing the bigger one.
				for (int j = left; j < right; ++j) {
					if (buildingHeight > height[j])
						height[j] = buildingHeight;
				}
			}
		}

		boolean notFirst = false; // only show a preceeding space on the non-first entries
		int currentHeight = 0;
		
		// Traverse throught height array
		for (int pos = 0; pos != 10000; ++pos) {
			if (height[pos] != currentHeight) {
				if (!notFirst)
					finalStr += " ";
				else
					notFirst = true;
				finalStr += pos + " " + height[pos];
				currentHeight = height[pos];
			}
		}
		return finalStr;
	}
}



