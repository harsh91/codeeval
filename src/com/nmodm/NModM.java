package com.nmodm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NModM {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		
		while(in.hasNextLine()) {
			String[] nums = in.nextLine().split(",");
			int N = Integer.parseInt(nums[0]);
			int M = Integer.parseInt(nums[1]);
			System.out.println(N % M);
		}
		in.close();
	}

}
