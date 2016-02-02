package com.longestlines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * LongestLines
 * Used for displaying n number of longest lines from a file.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/11/2015
 */
public class LongestLines {

	public static void main(String[] args) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
			String line = null;
			int counter = 0;
			ArrayList<String> list = new ArrayList<String>();
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				if (!line.equals("")) {
					if (counter == 0) {
						counter = Integer.parseInt(line);
					} else {
						list.add(line);
					}
				}
			}
			// Custom comparator for sorting elements of array list by string
			// length.
			Comparator<String> x = new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() > o2.length())
						return -1;
					if (o2.length() > o1.length())
						return 1;
					return 0;
				}
			};
			Collections.sort(list, x);

			for (int i = 0; i < counter; i++) {
				System.out.println(list.get(i));
			}
			buffer.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}