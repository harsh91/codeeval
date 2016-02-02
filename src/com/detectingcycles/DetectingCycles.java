package com.detectingcycles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * DetectingCycles https://www.codeeval.com/open_challenges/5/ Detecting the
 * first cycle found in a string. Input is read from a text file such that one
 * line is one input.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/16/2015 3:57PM
 */
public class DetectingCycles {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		ArrayList<String[]> list = new ArrayList<String[]>();
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				list.add(line.split(" "));
			}
		}
		if (list != null) {
			for (String str[] : list) {
				String repition = "";
				int index = -1;
				boolean flag = true;
				int counter = 0;
				while (index < 0 && counter < str.length) {
					index = search(counter, str, str[++counter]);
				}
				String firstElement = str[index];
				int temp = --counter;
				while (flag && counter < str.length) {
					if (temp < counter && firstElement.equals(str[counter])) {
						break;
					}
					if (str[counter].equals(str[index])) {
						repition += str[counter] + " ";
						counter++;
						index++;
					} else {
						flag = false;
					}
				}
				System.out.println(repition.trim());
			}
		}
		buffer.close();
	}

	private static int search(int currentIndex, String[] str, String string) {
		int index = -1;
		int counter = currentIndex + 1;
		while (index < 0 && counter < str.length) {
			if (str[currentIndex].equals(str[counter])) {
				index = counter;
				break;
			}
			counter++;
		}
		return index;
	}

}
