package com.removecharacters;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RemoveCharacters
 * Used for removing some characters from the string.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 09/11/2015
 */
public class RemoveCharacters {

	public static void main(String[] args) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
			String line = null;
			ArrayList<String> list = new ArrayList<String>();
			while ((line = buffer.readLine()) != null) {
				line = line.trim();
				if (!line.equals("")) {
					list.add(line);
				}
			}
			for (int counter = 0; counter < list.size(); counter++) {
				Pattern p = Pattern.compile(",(.*)");
				Matcher m = p.matcher(list.get(counter));
				if (m.find()) {
					String s = m.group(1).trim();
					String arr[] = s.split("");
					for (int i = 0; i < arr.length; i++) {
						list.set(counter, list.get(counter).replaceAll(arr[i], ""));
					}
				}
				System.out.println(list.get(counter).replace(",", "").trim());
			}
			buffer.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
