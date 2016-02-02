package com.texttonumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TextToNumber {

	public static void main(String[] args) throws IOException {

		String inline;
		FileReader file = new FileReader(args[0]);
		BufferedReader buffer = new BufferedReader(file);

		HashMap<String, Integer> map = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();

		map.put("zero", 0);
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		map.put("six", 6);
		map.put("seven", 7);
		map.put("eight", 8);
		map.put("nine", 9);
		map.put("ten", 10);
		map.put("eleven", 11);
		map.put("twelve", 12);
		map.put("thirteen", 13);
		map.put("fourteen", 14);
		map.put("fifteen", 15);
		map.put("sixteen", 16);
		map.put("seventeen", 17);
		map.put("eighteen", 18);
		map.put("nineteen", 19);
		map.put("twenty", 20);
		map.put("thirty", 30);
		map.put("fourty", 40);
		map.put("fifty", 50);
		map.put("sixty", 60);
		map.put("seventy", 70);
		map.put("eighty", 80);
		map.put("ninty", 90);

		map2.put("hundred", 100);
		map2.put("thousand", 1000);
		map2.put("million", 1000000);

		String text[] = null;

		while ((inline = buffer.readLine()) != null)

		{
			inline = inline.trim();
			System.out.println(inline);
			if (inline.equalsIgnoreCase("three million two hundred twenty five")) {
				System.out.println("Hello");
			}
			text = inline.toLowerCase().split(" ");

			if (!inline.isEmpty()) {
				int i, j, finalsum = 0, count = 0;
				int sum = 0;

				// For counting the number of multipliers
				for (i = 0; i < text.length; i++) {
					// if(text[i].equals(text[i].trim()))
					// System.out.println(text[i]);
					if (map2.get(text[i]) != null)
						count++;
				}

				int lastMul = 0;
				for (i = 0, j = 0; i <= count; i++) {
					sum = 0;

					for (; j < text.length; j++) {
						if(j == text.length-1) {
							sum += (map.get(text[j]));
						} else {
							if (map.get(text[j]) != null && map2.get(text[j+1]) == null) {
								sum += (map.get(text[j]));
							}
							if (map.get(text[j]) != null && map2.get(text[j+1]) != null) {
								System.out.println(text[j]);
								System.out.println(map2.get(text[j]));
								if(lastMul > map2.get(text[j])) {
									sum+=(map2.get(text[j]));
								} else {
									sum *= (map2.get(text[j]));
									lastMul = map2.get(text[j]);
								}
							}
						}
					}
					finalsum += sum;

				}
				if (text[0].equals("negative"))
					System.out.println("-" + finalsum);
				else
					System.out.println(finalsum);

			}

		}

		buffer.close();

	}

}
