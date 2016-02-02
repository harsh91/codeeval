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
public class BB {

	public static void main(String[] args) {
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(args[0]));
			String line;
			// list -> List of all points given as input.
			// bridges -> List of bridges numbers.
			ArrayList<String> list = new ArrayList<String>();
			HashMap<Integer, Integer> bridges = new HashMap<Integer, Integer>();
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
					bridges.put(Integer.parseInt(line.substring(0, line.indexOf(":")).trim()), 1);
					list.add(temp.replaceAll(" ", ""));
				}
			}
			buffer.close();

			// intersectionArray -> Storing the intersections in a matrix. With
			// all 1 as intersected and 0 as non intersecting.
			// hashmap -> storing the bridge number and its intersection count
			// with others.
			int intersectionArray[][] = new int[list.size()][list.size()];
			HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();

			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					String[] lineA = list.get(i).split(",");
					String[] lineB = list.get(j).split(",");
					if (Line2D.linesIntersect(new Double(lineA[0]), new Double(lineA[1]), new Double(lineA[2]),
							new Double(lineA[3]), new Double(lineB[0]), new Double(lineB[1]), new Double(lineB[2]),
							new Double(lineB[3]))) {
						if (hashmap.containsKey(i + 1)) {
							hashmap.put(i + 1, hashmap.get(i + 1) + 1);
						} else {
							hashmap.put(i + 1, 1);
						}
						if (hashmap.containsKey(j + 1)) {
							hashmap.put(j + 1, hashmap.get(j + 1) + 1);
						} else {
							hashmap.put(j + 1, 1);
						}
						intersectionArray[i][j] = 1;
						intersectionArray[j][i] = 1;
					}
				}
			}
			// Intersection part ends

			// looping till we do not remove all the intersections stored in
			// hashmap.
			while (hashmap.size() > 0) {
				Iterator<?> iterateHash = hashmap.entrySet().iterator();
				int maxIntersectingBridge = -1;
				int maxIntersectingBridgeCount = -1;

				// find max occurrence element, value and process them.
				// element will be removed from the hashmap later.
				// value will tell how many it intersect to.
				while (iterateHash.hasNext()) {
					Map.Entry<Integer, Integer> pair = (Entry<Integer, Integer>) iterateHash.next();
					if (pair.getValue() > maxIntersectingBridgeCount) {
						maxIntersectingBridgeCount = pair.getValue();
						maxIntersectingBridge = pair.getKey();
					}
				}
				int removeIntersectingWithMax[] = new int[maxIntersectingBridgeCount + 1];
				removeIntersectingWithMax[0] = maxIntersectingBridge;
				int counter = 1;
				maxIntersectingBridge--;
				// Removing the maxIntersectingBridge from the matrix vertically
				// and horizontally.
				for (int i = 0; i < intersectionArray.length; i++) {
					if (intersectionArray[maxIntersectingBridge][i] == 1
							|| intersectionArray[i][maxIntersectingBridge] == 1) {
						removeIntersectingWithMax[counter++] = i + 1;
					}
					intersectionArray[maxIntersectingBridge][i] = 0;
					intersectionArray[i][maxIntersectingBridge] = 0;
				}
				for (int i = 0; i < removeIntersectingWithMax.length; i++) {
					if (hashmap.get(removeIntersectingWithMax[i]) > 1
							&& (removeIntersectingWithMax[i] != (maxIntersectingBridge + 1))) {
						hashmap.put(removeIntersectingWithMax[i], hashmap.get(removeIntersectingWithMax[i]) - 1);
					} else {
						hashmap.remove(removeIntersectingWithMax[i]);
					}
				}
				bridges.remove(removeIntersectingWithMax[0]);
			}
			Iterator finalIterate = bridges.entrySet().iterator();
			while (finalIterate.hasNext()) {
				Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) finalIterate.next();
				System.out.println(pair.getKey());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * 
	 * @param corAX1
	 * @param corAY1
	 * @param corAX2
	 * @param corAY2
	 * @param corAX5
	 * @param corAY5
	 * @param corAX6
	 * @param corAY6
	 * @return
	 */
	public boolean intersects(double corAX1, double corAY1, double corAX2, double corAY2, double corAX5, double corAY5,
			double corAX6, double corAY6) {
		return ((corAY2 - corAY1) * (corAX5 - corAX1) > (corAY5 - corAY1) * (corAX2 - corAX1)) != ((corAY2 - corAY1)
				* (corAX6 - corAX1) > (corAY6 - corAY1) * (corAX2 - corAX1))
				&& ((corAY6 - corAY5) * (corAX1 - corAX5) > (corAY1 - corAY5) * (corAX6 - corAX5)) != ((corAX6 - corAY5)
						* (corAX2 - corAX5) > (corAY2 - corAY5) * (corAX6 - corAX5));
	}

}