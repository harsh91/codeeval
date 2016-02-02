package com.firstnonrepeatedcharacter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * FirstNonRepeatedCharacter
 * Used for searching first non repeating character from the string.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/11/2015
 */
public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
			String line = null;
			ArrayList<String> list = new ArrayList<String>();
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				if (!line.equals("")) {
					list.add(line);
					System.out.println(firstNonRepeatedCharacter(line));
				}
			}
			buffer.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public static Character firstNonRepeatedCharacter(String str) {
		HashMap<Character, Integer> characterhashtable = new HashMap<Character, Integer>();
		int i, length;
		Character c;
		length = str.length();
		for (i = 0; i < length; i++) {
			c = str.charAt(i);
			if (characterhashtable.containsKey(c)) {
				characterhashtable.put(c, characterhashtable.get(c) + 1);
			} else {
				characterhashtable.put(c, 1);
			}
		}
		for (i = 0; i < length; i++) {
			c = str.charAt(i);
			if (characterhashtable.get(c) == 1)
				return c;
		}
		return null;
	}
}