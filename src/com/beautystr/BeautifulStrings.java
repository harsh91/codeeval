package com.beautystr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * BeautifulStrings
 * Calculating the maximum beauty of strings.
 * The text is taken from a file path of that file is passed to program at  run time through arguments.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 08/28/2015
 */
public class BeautifulStrings {
	
	static ArrayList<String> sortedList = new ArrayList<String>();
	
	/**
	 * main
	 * Main method
	 * 
	 * @author Harsh <girdharharsh01@gmail.com>
	 * @since 08/28/2015
	 * @param args Arguments passed while running the program.
	 */
	public static void main(String[] args) {
		File file = new File(args[0]);
		try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = buffer.readLine()) != null) {
		    	sortedList.add(line);
		    }
		    for (String element : sortedList) {
		        if(!element.equalsIgnoreCase("")) {
		        	System.out.println(beautify(element));
		        }
		    }
		} catch (Exception exception) {
			System.out.println("Hell Exception!!" + exception);
			exception.printStackTrace();
		}
	}

	/**
	 * beautify
	 * Method used to calculate maximum beauty of strings.
	 * Internally it get values from hashmap and sorts it in descending order.
	 * 
	 * @author Harsh <girdharharsh01@gmail.com>
	 * @since 08/28/2015
	 * @param str String Passed by buffer line by line from file read.
	 * @return Integer Maximum beauty of a string.
	 */
	private static int beautify(String str) throws Exception {
		str = str.replaceAll("\\s", "").trim().toLowerCase().replaceAll("[^a-zA-Z]+\\.?", "");
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < str.length(); i++){
		   char c = str.charAt(i);
		   Integer val = map.get(new Character(c));
		   if(val != null){
		     map.put(c, new Integer(val + 1));
		   }else{
		     map.put(c, 1);
		   }
		}
		ArrayList<Integer> sortedList = new ArrayList<Integer>(map.values());
		Collections.sort(sortedList);
		Collections.sort(sortedList, Collections.reverseOrder());
		int counter = 26;
		int total = 0;
	    for(Integer value : sortedList) {
	        total += counter * value;
	        counter--;
	    }
	    return total;
	}
}