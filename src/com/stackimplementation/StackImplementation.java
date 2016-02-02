package com.stackimplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StackImplementation {

	static ArrayList<Integer> numberStack = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			if (!line.equals("")) {
				String numbers[] = line.split(" ");
				for (int i = 0 ; i < numbers.length ; i++) {
					push(Integer.parseInt(numbers[i]));
				}
				pop();
				numberStack.clear();
			}
		}
		buffer.close();
	}
	
	public static void push(int number) {
		numberStack.add(number);
	}
	
	public static void pop() {
		for (int i = numberStack.size() - 1 ; i >= 0 ; i -= 2) {
			if ( i == 0 || i == 1 ) {
				System.out.print(numberStack.get(i));
			} else {
				System.out.print(numberStack.get(i) + " ");
			}
		}
		System.out.println();
	}

}
