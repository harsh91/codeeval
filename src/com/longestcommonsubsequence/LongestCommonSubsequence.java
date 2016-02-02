package com.longestcommonsubsequence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * LongestCommonSubsequence
 * Find out the common longest common sub sequence from between two strings.
 * 
 * EX: XMJYAUZ;MZJAWXU
 * SOL: MJAU
 * 
 * NOTE: Empty lines will be ignored.
 * 
 * Separate Components working inside:
 * 1) Takes input from file and work one by one on every test case.
 * 2) Save 2 inputs in 2 different arrays.
 * 3) matching both array when equal increment by one to the highest value above or left to that node.
 * 4) Back track our 2d array and get the longest common subsequence.
 * 
 * @author Harsh
 * @since 10/28/2015 5:06PM
 * @since 11/03/2015 5:44PM
 */
public class LongestCommonSubsequence {

	ArrayList<String> inputList = new ArrayList<String>();
	
	public static void main(String[] args) throws Exception {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		boolean isReadComplete = lcs.getInput(args[0]);
		if(isReadComplete) {
			System.out.println(new StringBuilder(lcs.readInput()).reverse().toString());
		} else {
			throw new Exception("Reading file is having exception.");
		}
	}

	/**
	 * readInput
	 * Working on the input provided.
	 * 
	 */
	public String readInput() {
		String finalSol = "";
		for(String input : inputList) {
			String inputs[] = input.trim().split(";");
			String input1[] = inputs[0].split("");
			String input2[] = inputs[1].split("");
			Integer solution[][] = new Integer[input1.length][input2.length];
			String LCS[][] = new String[input1.length][input2.length];
			for(int i = 0 ; i < input1.length ; i++) {
				for(int j = 0 ; j < input2.length ; j++) {
					if(i == 0 || j == 0) {
						solution[i][j] = 0;
						LCS[i][j] = "0";
					} else if(input1[i].equals(input2[j])) {
						solution[i][j] = solution[i-1][j-1] + 1;
						LCS[i][j] = "diagonal";
					} else {
						if(solution[i-1][j] < solution[i][j-1]) {
							solution[i][j] = solution[i][j-1];
							LCS[i][j] = "left";
						} else {
							solution[i][j] = solution[i-1][j];
							LCS[i][j] = "top";
						}
					}
				}
			}
			LongestCommonSubsequence lcs = new LongestCommonSubsequence();
			finalSol += lcs.backTrack(input1, input2, LCS);
		}
		return finalSol;
	}

	/**
	 * backTrack
	 * Tracking the 2d array which is formed from readInput function.
	 * @param input2 
	 * @param input1 
	 * 
	 * @param solution
	 * @param lCS 
	 */
	private String backTrack(String[] input1, String[] input2, String[][] lcs) {
		String finalSol = "";
		int in1Len = input1.length-1;
		int in2Len = input2.length-1;
		String x = lcs[in1Len][in2Len];
		while(!x.equals("0")) {
			if(lcs[in1Len][in2Len].equals("diagonal")) {
				finalSol = input1[in1Len];
				in1Len--;
				in2Len--;
			} else if (lcs[in1Len][in2Len].equals("top")) {
				in1Len--;
			} else if(lcs[in1Len][in2Len].equals("left")) {
				in2Len--;
			}
			x = lcs[in1Len][in2Len];
		}
		return finalSol;
	}

	/**
	 * getInput
	 * Gets the input from the file.
	 * 
	 * @param filePath Path of the file
	 * @return boolean
	 * @throws IOException
	 */
	public boolean getInput(String filePath) throws IOException {
		File file = new File(filePath);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				inputList.add(line.trim());
			}
		}
		buffer.close();
		return true;
	}
}
