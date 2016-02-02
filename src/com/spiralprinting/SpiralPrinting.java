package com.spiralprinting;

public class SpiralPrinting {

	public static void main(String[] args) {
//		String line = "3;3;1 2 3 4 5 6 7 8 9";
//		String in[] = line.trim().split(";");
//		String matrix[][] = new String[Integer.parseInt(in[0])][Integer.parseInt(in[1])];
//		for(int i = 0, k = 0 ; i < matrix[0].length ; i++) {
//			int j = 0;
//			matrix[i][j++] = ""+in[2].charAt(k++);
//			matrix[i][j++] = ""+in[2].charAt(k++);
//			matrix[i][j++] = ""+in[2].charAt(k++);
//		}
//		System.out.println(in[0]);
//		System.out.println(in[1]);
//		System.out.println(in[2]);
//		new SpiralPrinting().printArray(matrix);
		
		String matrix[][] = {{"1","2","3"}, {"4","5","6"}, {"7","8","9"}};
//		new SpiralPrinting().printArray(matrix);
		new SpiralPrinting().printArraySprially(matrix);
	}

	private void printArraySprially(String[][] matrix) {
		int width = matrix[0].length;
		int height = matrix.length;
		int widthCounter = width;
		int heightCounter = height-1;
		int mainCounter = width;
		boolean flag = true;
		boolean direction = true;
		while(heightCounter > 0 && widthCounter > 0) {
			if(flag) {//width case
				for(int i = 0 ; i < widthCounter ; i++) {
					if(direction) {//+ve direction ->
						
						direction = false;
					} else {
						
						direction = true;
					}
				}
			} else {//height case
				for(int i = 0 ; i < widthCounter ; i++) {
					
				}
			}
		}
		
	}

	private void printArray(String[][] matrix) {
		for(int i = 0 ; i < matrix.length ; i++) {
			for(int j = 0 ; j < matrix[i].length ; j++) {
				System.out.print(matrix[i][j]+"   ");
			}
			System.out.println();
		}
	}

}
