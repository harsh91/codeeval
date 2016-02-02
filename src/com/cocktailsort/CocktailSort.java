package com.cocktailsort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * CocktailSort
 * Print sorted numbers after they pass the required number of
 * iterations. One iteration of a cocktail sort is a pass through the list of
 * numbers in both directions: from the beginning to the end and from the end to
 * the beginning
 * 
 * @author Harsh
 * @since 01/20/2016 1:45 PM
 */
public class CocktailSort {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				String inputs[] = line.split("\\|");
				String element[] = inputs[0].split(" ");
				int elements[] = stringToIntArray(element);
				int iterate = Integer.parseInt(inputs[1].trim());
				printCocktailSort(cocktailSort(elements, iterate));
			}
		}
		buffer.close();
	}

	private static void printCocktailSort(int[] cocktailSort) {
		for (int element : cocktailSort) {
			System.out.print(element+ " ");
		}
		System.out.println();
	}

	private static int[] stringToIntArray(String[] element) {
		int intArray[] = new int[element.length];
		for (int i = 0; i < element.length; i++) {
			if (!element[i].trim().equals("")) {
				intArray[i] = Integer.parseInt(element[i]);
			}
		}
		return intArray;
	}

	private static int[] cocktailSort(int[] elements, int iterate) {
		int frontLimit = 0, backLimit = elements.length - 1;
		for (int i = 0; i < iterate; i++) {
			for (int j = frontLimit ; j < backLimit ; j++) {
				if (elements[j] > elements[j + 1]) {
					int temp = elements[j];
					elements[j] = elements[j+1];
					elements[j+1] = temp;
				}
			}
			backLimit--;
			for (int j = backLimit ; j > frontLimit ; j--) {
				if (elements[j] < elements[j - 1]) {
					int temp = elements[j];
					elements[j] = elements[j - 1];
					elements[j - 1] = temp;
				}
			}
			frontLimit++;
		}
		return elements;
	}

}
