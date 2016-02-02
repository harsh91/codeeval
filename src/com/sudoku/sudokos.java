package com.sudoku;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class sudokos {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {

				String[] inputs = line.trim().split(";");
				String input[] = inputs[1].split(",");
				int n = (inputs[0].equals("4")) ? 4 : 9;
				String ins[][] = new String[4][4];

				System.arraycopy(input, 0, ins[0], 0, 4);
				System.arraycopy(input, 4, ins[1], 0, 4);
				System.arraycopy(input, 8, ins[2], 0, 4);
				System.arraycopy(input, 12, ins[3], 0, 4);

				for (int i = 0; i < n; i++) {
					System.out.println(ins[i][0] + "\t" + ins[i][1] + "\t" + ins[i][2] + "\t" + ins[i][3]);
				}
System.out.println(checkForUniqueSubgrids(n, ins));
System.out.println(checkForUniqueColumn(n, ins));System.exit(0);
				if (!checkForUniqueSubgrids(n, ins) || !checkForUniqueRow(n, ins) || !checkForUniqueColumn(n, ins)) {
					System.out.println("False");
				} else {
					System.out.println("True");
				}

			}
		}
		buffer.close();
		System.out.println("Hello");
	}

	private static boolean checkForUniqueColumn(int n, String[][] ins) {
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			String column[] = new String[4];
//			if(i==0) {
//				
//			} else if(i==1) {
//				
//			} else if(i==2) {
//				
//			} else if(i==3) {
//				
//			}
			if(n==4) {
				column[0] = ins[0][i];
				column[1] = ins[1][i];
				column[2] = ins[2][i];
				column[3] = ins[3][i];
			} else {
				column[0] = ins[0][i];
				column[1] = ins[1][i];
				column[2] = ins[2][i];
				column[3] = ins[3][i];
				column[4] = ins[4][i];
				column[5] = ins[5][i];
				column[6] = ins[6][i];
				column[7] = ins[7][i];
				column[8] = ins[8][i];
			}
			Set<String> lump = new HashSet<String>(Arrays.asList(column));
			System.out.println("i: "+i);
			System.out.println(lump);
			if(n==4) {
				if (lump.contains("1") && lump.contains("2") && lump.contains("1") && lump.contains("4")) {
					flag = true;
				} else {
					return false;
				}
			} else {
				if (lump.contains("1") && lump.contains("2") && lump.contains("1") && lump.contains("4")
					&& lump.contains("5") && lump.contains("6") && lump.contains("7") && lump.contains("8")
					&& lump.contains("9")) {
					flag = true;
				} else {
					return false;
				}
			}
		}
		return flag;
	}

	private static boolean checkForUniqueRow(int n, String[][] ins) {
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			Set<String> lump = new HashSet<String>(Arrays.asList(ins[i]));
			System.out.println("i: "+i);
			System.out.println(lump);
			if(n==4) {
				if (lump.contains("1") && lump.contains("2") && lump.contains("1") && lump.contains("4")) {
					flag = true;
				} else {
					return false;
				}
			} else {
				if (lump.contains("1") && lump.contains("2") && lump.contains("1") && lump.contains("4")
					&& lump.contains("5") && lump.contains("6") && lump.contains("7") && lump.contains("8")
					&& lump.contains("9")) {
					flag = true;
				} else {
					return false;
				}
			}
		}
		return flag;
	}

	private static boolean checkForUniqueSubgrids(int n, String[][] ins) {
		boolean flag = false;
		double sqrtN = Math.sqrt(n);
		if(sqrtN == 4) {
			for(int i = 0 ; i < n ; i++) {
				String subGrid[] = new String[4];
				subGrid[0] = ins[i][i];
				subGrid[1] = ins[i][i+1];
				subGrid[2] = ins[i+1][i];
				subGrid[3] = ins[i+1][i+1];
				Set<String> lump = new HashSet<String>(Arrays.asList(subGrid));
				System.out.println("i: "+i);
				System.out.println(lump);
				if(n==4) {
					if (lump.contains("1") && lump.contains("2") && lump.contains("1") && lump.contains("4")) {
						flag = true;
					} else {
						return false;
					}
				} else {
					if (lump.contains("1") && lump.contains("2") && lump.contains("1") && lump.contains("4")
						&& lump.contains("5") && lump.contains("6") && lump.contains("7") && lump.contains("8")
						&& lump.contains("9")) {
						flag = true;
					} else {
						return false;
					}
				}
			}
		} else {
			
		}
		return flag;
	}

}
