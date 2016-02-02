package com.computerterminal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ComputerTerminal
 * 
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 
 * 
 * Some conditions to built on : 
 * ^c - clear the entire screen; the cursor row and column do not change
 * ^h - move the cursor to row 0, column 0; the image on the screen is not changed
 * ^b - move the cursor to the beginning of the current line; the cursor row does not change
 * ^d - move the cursor down one row if possible; the cursor column does not change
 * ^u - move the cursor up one row, if possible; the cursor column does not change
 * ^l - move the cursor left one column, if possible; the cursor row does not change
 * ^r - move the cursor right one column, if possible; the cursor row does not change
 * ^e - erase characters to the right of, and including, the cursor column on the cursor's row; the cursor row and column do not change
 * ^i - enter insert mode
 * ^o - enter overwrite mode
 * ^^ - write a circumflex (^) at the current cursor location, exactly as if it was not a special character; this is subject to the actions of the current mode (insert or overwrite)
 * ^DD - move the cursor to the row and column specified; each D represents a decimal digit; the first D represents the new row number, and the second D represents the new column number 
 */
public class ComputerTerminal {

	public static void main(String[] args) throws IOException {
		long starttime = System.nanoTime();
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = null;
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				String input[] = line.trim().split(" ");
				
			}
			System.exit(0);
		}
		buffer.close();
		long endtime = System.nanoTime();
		System.out.println("time : " + (endtime - starttime));
	}

}
