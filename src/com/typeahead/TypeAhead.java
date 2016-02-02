package com.typeahead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * TypeAhead
 * States the probability of next coming words. Takes in a file as
 * input parse it line by line and for every line tells the probability of
 * upcoming words based on some string.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 08/10/2015 3:21PM
 */
public class TypeAhead {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String input = null;

		// reading input line by line
		while ((input = buffer.readLine()) != null) { // reading input file
			String check = null;
			String[] values = null;
			String line;

			int ngramLength = 0;
			ArrayList<String> list = new ArrayList<String>();
			values = input.split(",");
			ngramLength = Integer.parseInt(values[0]);
			check = values[1];

			// hard-coded string to check for upcoming substrings.
			line = "Mary had a little lamb its fleece was white as snow And everywhere that Mary went the lamb was sure to go "
					+ "It followed her to school one day which was against the rule "
					+ "It made the children laugh and play to see a lamb at school "
					+ "And so the teacher turned it out but still it lingered near And waited patiently about till Mary did appear "
					+ "Why does the lamb love Mary so the eager children cry Why Mary loves the lamb you know the teacher did reply";

			values = line.split(" ");
			int inputLength = check.trim().split(" ").length;
			int i = 0;
			// matching the values and storing their values in list.
			while (i < values.length - inputLength - 1) {
				String toMatch = "";
				int counter = 0;
				for (int k = 0; k < inputLength; k++) {
					toMatch += values[i + k] + " ";
					counter++;
				}
				String newMatch = "";
				if (check.trim().equals(toMatch.trim())) {
					for (int k = 0; k < ngramLength - counter; k++)
						newMatch += values[i + k + ngramLength - 1] + " ";
					list.add(newMatch.trim());
				}
				i++;
			}

			// Changing collections to arrange items.
			Set<String> uniqueWords = new TreeSet<String>(list);
			String[] words = new String[uniqueWords.size()];
			String[] counts = new String[uniqueWords.size()];

			int k = 0;
			for (String word : uniqueWords) {
				words[k] = word;
				counts[k] = String.valueOf(Collections.frequency(list, word));
				k++;
			}

			// sorting unique words collections in descending order
			String countWords[][] = new TypeAhead().sortDesc(counts, words, uniqueWords.size());
			counts = countWords[0];
			words = countWords[1];
			// displaying final set of values with their probabilities
			DecimalFormat df = new DecimalFormat("0.000");
			for (k = 0; k < uniqueWords.size(); k++) {
				if(k != uniqueWords.size() - 1)
					System.out.print(words[k] + "," + df.format((float) Integer.parseInt(counts[k]) / list.size()) + ";");
				else
					System.out.print(words[k] + "," + df.format((float) Integer.parseInt(counts[k]) / list.size()));
			}
			System.out.println();
		}
		// closing the resources used
		buffer.close();
	}

	/**
	 * sortDesc
	 * Method used to sort the arrays in descending order.
	 * 
	 * @param counts
	 * @param words
	 * @param length
	 * @return String[][] array of counts and words after sorting in descending order.
	 */
	public String[][] sortDesc(String[] counts, String[] words, int length) {
		String tempText;
		for (int i = 0; i < (length - 1); i++) {
			for (int j = 0; j < length - i - 1; j++) {
				if (Integer.parseInt(counts[j]) < Integer.parseInt(counts[j + 1])) {
					// arranging Text occurrence value
					tempText = counts[j];
					counts[j] = counts[j + 1];
					counts[j + 1] = tempText;
					// arranging text value
					tempText = words[j];
					words[j] = words[j + 1];
					words[j + 1] = tempText;
				}
			}
		}
		String countWords[][] = new String[2][];
		countWords[0] = counts;
		countWords[1] = words;
		return countWords;
	}

}