package com.sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Sudoku Checks for a sudoku solution is valid or not. For Sudoku to be valid
 * three conditions should be true: Each row, column and sub grids should have
 * each 1-4 or 1-9 unique numbers and length depends on sudoku matrix. Row: is
 * from left to right Column: is from top to bottom sub grids: if the sudoku is
 * 4x4 than there are 4 2x2 sub grids, similarly if the sudoku is 9x9 than there
 * are 9 3x3 sub grids.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 11/22/2015 6:30PM
 */
public class Sudoku {

	public static void main(String args[]) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		// reading the input file line by line each test case.
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				String[] sudokuInput = line.trim().split(";");
				String input[] = sudokuInput[1].split(",");
				int n = (sudokuInput[0].equals("4")) ? 4 : 9;
				String ins[][] = null;
				int intArray[][] = null;
				// creating sudoku inputs into array of length 4 or 9 depends on
				// input
				if (n == 4) {
					ins = new String[4][4];
					System.arraycopy(input, 0, ins[0], 0, 4);
					System.arraycopy(input, 4, ins[1], 0, 4);
					System.arraycopy(input, 8, ins[2], 0, 4);
					System.arraycopy(input, 12, ins[3], 0, 4);
					intArray = new int[4][4];
				} else {
					ins = new String[9][9];
					System.arraycopy(input, 0, ins[0], 0, 9);
					System.arraycopy(input, 9, ins[1], 0, 9);
					System.arraycopy(input, 18, ins[2], 0, 9);
					System.arraycopy(input, 27, ins[3], 0, 9);
					System.arraycopy(input, 36, ins[4], 0, 9);
					System.arraycopy(input, 45, ins[5], 0, 9);
					System.arraycopy(input, 54, ins[6], 0, 9);
					System.arraycopy(input, 63, ins[7], 0, 9);
					System.arraycopy(input, 72, ins[8], 0, 9);
					intArray = new int[9][9];
				}
				// converting string array to integer
				for (int i = 0; i < ins.length; i++) {
					for (int j = 0; j < ins.length; j++) {
						intArray[i][j] = Integer.parseInt(ins[i][j]);
					}
				}
				// checking for sudoku valid or not
				if (new Sudoku().isSudokuValid(intArray))
					System.out.println("True");
				else
					System.out.println("False");
			}
		}
		buffer.close();
	}

	/**
	 * isSudokuValid Checks if the given sudoku is valid or not.
	 * 
	 * @param intArray
	 *            Pass the sudoku 2d array which is to be tested.
	 * @return boolean True if the sudoku array is valid or false if not.
	 */
	private boolean isSudokuValid(int[][] intArray) {
		int sqrtN = (int) Math.sqrt(intArray.length);
		int n = intArray.length;
		for (int i = 0; i < n; i++) {
			// creating 3 types of array
			int[] columnArray = new int[n];
			int[] squareArray = new int[n];
			int[] rowArray = intArray[i].clone();

			for (int j = 0; j < n; j++) {
				columnArray[j] = intArray[j][i];
				squareArray[j] = intArray[(i / sqrtN) * sqrtN + j / sqrtN][i * sqrtN % n + j % sqrtN];
			}
			if (!(isValid(rowArray) && isValid(columnArray) && isValid(squareArray)))
				return false;
		}
		return true;
	}

	/**
	 * isValid Sorting the array and than checking if the array has all values 1-4 or
	 * 1-9.
	 * 
	 * @param array
	 *            Pass the array which is to checked.
	 * @return boolean True if is valid or false if not valid array.
	 */
	private boolean isValid(int[] array) {
		int counter = 0;
		Arrays.sort(array);
		for (int value : array) {
			if (value != counter) {
				return false;
			}
			counter++;
		}
		return true;
	}
}
