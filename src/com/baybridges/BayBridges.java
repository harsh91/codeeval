package com.baybridges;

import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * BayBridges Class used for finding maximum number of bridges that can be build
 * without coinciding with each other.
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since 08/30/2015
 *
 */
public class BayBridges {

	public static void main(String[] args) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
			String line;
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> bridges = new ArrayList<String>();
			HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
			while ((line = buffer.readLine()) != null) {
				if (!line.trim().equalsIgnoreCase("")) {
					final Pattern pattern = Pattern.compile("\\[(.+?)\\]");
					final Matcher matcher = pattern.matcher(line.trim());
					String temp = "";
					while (matcher.find()) {
						if (!temp.trim().equalsIgnoreCase("")) {
							temp += ",";
						}
						temp += matcher.group(0).replaceAll("\\[", "").replaceAll("\\]", "");
					}
					bridges.add(line.substring(0, 1).trim());
					list.add(temp.replaceAll(" ", ""));
				}
			}
			ArrayList<String> noway = new ArrayList<String>();
			int intersectionArray[][] = new int[list.size()][list.size()];

			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					String[] lineA = list.get(i).split(",");
					String[] lineB = list.get(j).split(",");
					if (Line2D.linesIntersect(new Double(lineA[0]), new Double(lineA[1]), new Double(lineA[2]),
							new Double(lineA[3]), new Double(lineB[0]), new Double(lineB[1]), new Double(lineB[2]),
							new Double(lineB[3]))) {
						if (hashmap.containsKey(i)) {
							hashmap.put(i, hashmap.get(i) + 1);
						} else {
							hashmap.put(i, 1);
						}
						if (hashmap.containsKey(j)) {
							hashmap.put(j, hashmap.get(j) + 1);
						} else {
							hashmap.put(j, 1);
						}
						noway.add(i + "," + j);
						intersectionArray[i][j] = 1;
						intersectionArray[j][i] = 1;
					}
				}
			}
			// -----------------------------------------------------------------
			int arl[][] = new int[hashmap.size()][hashmap.size()];
			int counter = 0;
			// -----------------------------------------------------------------
			Iterator<?> its = hashmap.entrySet().iterator();
			while (its.hasNext()) {
				Map.Entry<Integer, Integer> pair = (Entry<Integer, Integer>) its.next();
				arl[counter][0] = pair.getValue();
				arl[counter][1] = pair.getKey();
				counter++;
			}
			// ------------------------------------------------------
			java.util.Arrays.sort(arl, new java.util.Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return -Integer.compare(a[0], b[0]);
				}
			});
			// System.exit(0);
			boolean ohgod = true;
			ArrayList<String> nobhai = new ArrayList<String>();
			ArrayList<String> noways = noway;
			while (noway.size() > 0) {
				for (int i = 0; i < arl.length; i++) {
					if (arl[i][1] > 1) {
						int count = 0;
						for (String s : noway) {
							if (count == 0) {
								bridges.remove("" + (arl[i][1] + 1));
								count++;
							}
							String splits[] = s.split(",");
							if (splits[0].equals(String.valueOf(arl[i][1]))
									|| splits[1].equals(String.valueOf(arl[i][1]))) {
								nobhai.add(s);
							}
						}
						noway.removeAll(nobhai);
					}
				}
			}
			for (String bridge : bridges)
				System.out.println(bridge);
			// for (String nowy : noway)
			// System.out.println("noway: "+nowy);
			// for (String nowys : noways)
			// System.out.println("nowys: "+nowys);
			// for (String bhai : nobhai)
			// System.out.println("bhai: "+bhai);
			// ------------------------------------------------------
			buffer.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}