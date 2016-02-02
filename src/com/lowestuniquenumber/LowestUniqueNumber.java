package com.lowestuniquenumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LowestUniqueNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				System.out.println(getLowestUniqueNumber(line.trim()));
			}
		}
		buffer.close();
	}

	public static String getLowestUniqueNumber(String line) {
		String str[] = line.split(" ");
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(str));
		for (int i = 0; i < str.length; i++) {
			if (hash.containsKey(str[i])) {
				hash.put(str[i], hash.get(str[i]) + 1);
			} else {
				hash.put(str[i], 1);
			}
		}
		Iterator<Entry<String, Integer>> iterator = hash.entrySet().iterator();
		String unique = "";
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> pair = (Entry<String, Integer>) iterator.next();
			if (pair.getValue() == 1) {
				unique = pair.getKey();
				break;
			}
		}
		if (unique.equals("")) {
			return "0";
		}
		return String.valueOf(list.indexOf(unique) + 1);
	}

}
