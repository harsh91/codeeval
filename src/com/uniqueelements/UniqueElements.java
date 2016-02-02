package com.uniqueelements;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class UniqueElements {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
		String line = "";
		while((line = buffer.readLine()) != null) {
			if(!line.trim().equals("")) {
				String ins[] = line.split(",");
				System.out.println(removeDuplicate(ins));
			}
		}
		buffer.close();
	}

	private static String removeDuplicate(String[] ins) {
		String finalStr = "";
		TreeMap<Integer, Integer> hash = new TreeMap<Integer, Integer>();
		for(int i = 0 ; i < ins.length ; i++) {
			hash.put(Integer.parseInt(ins[i]), 0);
		}
		Iterator itr = hash.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry map = (Map.Entry) itr.next();
			finalStr += map.getKey()+",";
		}
		return finalStr.substring(0, finalStr.length()-1);
	}

}
