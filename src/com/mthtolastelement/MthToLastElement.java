package com.mthtolastelement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Used for searching mth element from last of every string.
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/05/2015 02:43
 */
public class MthToLastElement {

	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
			String line = null;
			while ((line = buffer.readLine()) != null) {
				if (!line.equals("")) {
					String arr[] = line.trim().split(" ");
					int mthElement = Integer.parseInt(arr[arr.length - 1]);
					try {
						System.out.println(arr[arr.length - mthElement - 1]);
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
			}
			buffer.close();
	}

}
