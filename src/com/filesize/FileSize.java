package com.filesize;

import java.io.File;

/**
 * FileSize
 * Displays the size of file. Takes input as file path.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/19/2015 12:48AM
 */
public class FileSize {

	public static void main(String[] args) {
		File f = new File(args[0]);
		System.out.println(f.length());
	}

}
