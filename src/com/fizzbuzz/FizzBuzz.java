package com.fizzbuzz;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FizzBuzz {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
			String line = null;
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				if (!line.equals("")) {
					String[] arr = line.split(" ");
					if(arr.length == 3) {
						int f = Integer.parseInt(arr[0]);
						int b = Integer.parseInt(arr[1]);
						int n = Integer.parseInt(arr[2]);
						for (int i = 1 ; i <= n ; i++) {
							if ((i % f == 0) && (i % b == 0)) System.out.print("FB");
							else if (i % f == 0) System.out.print("F");
							else if (i % b == 0) System.out.print("B");
							else System.out.print(i+"");
							System.out.print(i < n ? " " : "\n");
						}
					}
				}
			}
			buffer.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
