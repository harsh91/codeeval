package com.hextodecimal;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HexToDecimal {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File(args[0]);
		Scanner in = new Scanner(file);
		
		while(in.hasNextLine()) {
			System.out.println(hex2decimal(in.nextLine()));
		}
		in.close();
	}

	public static int hex2decimal(String s) {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }
}
