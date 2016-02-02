package com.skyscrapers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SkyScraper {
	
	/*
	 * The solution uses the divide and conquer strategy -> time complexity: O(nlogn)
	 * Divide - split the problem into subproblems 
	 * Conquer - solve the subproblems 
	 * Merge - merge the subsolutions.
	 * 
	 * Space complexity O(n)
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader(args[0]));

		String line = "";
		while ((line = buffer.readLine()) != null) {
			Building[] buildings = null;
			int height[] = new int[10001];
			int left, right, buildingHeight;
			String finalStr = "";
			if (!line.trim().equals("")) {
				String inputs[] = line.trim().split(";");
				buildings = new Building[inputs.length];
				// reading each building in one case.
				for (int i = 0; i < inputs.length; i++) {
					inputs[i] = inputs[i].replace("(", "").replace(")", "");
					String ins[] = inputs[i].split(",");
					System.out.println(ins[0].trim());
//					buildings[i].left = Integer.parseInt(ins[0].trim());
//					buildings[i].height = Integer.parseInt(ins[1].trim());
//					buildings[i].right = Integer.parseInt(ins[2].trim());
					buildings[i] = new Building(Integer.parseInt(ins[0].trim()), Integer.parseInt(ins[1].trim()),
							Integer.parseInt(ins[0].trim()));
				}
			}
			System.out.println(findSkyline(buildings));
		}
	}
	
	public static ArrayList<Point> findSkyline(Building[] buildings){
		int n = buildings.length;
		if(n == 1){
			ArrayList<Point> sl = new ArrayList<Point>();
			sl.add(new Point(buildings[0].left, buildings[0].height));
			sl.add(new Point(buildings[0].right, 0));
			return sl;
		}
		ArrayList<Point> sl1 = findSkyline(Arrays.copyOfRange(buildings, 0,n/2 ));
		ArrayList<Point> sl2 = findSkyline(Arrays.copyOfRange(buildings, n/2+1, n ));
		return merge(sl1, sl2);
		
	}
	
	public static ArrayList<Point> merge(ArrayList<Point> sl1, ArrayList<Point> sl2){
		ArrayList<Point> skyline = new ArrayList<Point>();
		int curH1=0, curH2=0, curX=0;
		while(!sl1.isEmpty() && !sl2.isEmpty()){
			System.out.println(sl1.get(sl1.size()-1));
			System.out.println(sl2.get(sl2.size()-1));
			if( sl1.get(sl1.size()-1).x < sl2.get(sl2.size()-1).x ){
				curX = sl1.get(sl1.size()-1).x;
				curH1 = sl1.get(sl1.size()-1).y;
				sl1.remove(sl1.size()-1);
				skyline.add(new Point(curX, Math.max(curH1, curH2)));
			}else{
				curX = sl2.get(sl2.size()-1).x;
				curH1 = sl2.get(sl2.size()-1).y;
				sl2.remove(sl2.size()-1);
				skyline.add(new Point(curX, Math.max(curH1, curH2)));
			}
		}
		if(sl1.isEmpty()){
			skyline.addAll(sl2);
		}else if(sl2.isEmpty()){
			skyline.addAll(sl1);
		}
		return skyline;
		
	}

	public static class Building{
		int left, right, height;

		public Building(int left, int right, int height) {
			this.left = left;
			this.right = right;
			this.height = height;
		}
		
		
	}
	
	public static class Point{
		public int x, y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}