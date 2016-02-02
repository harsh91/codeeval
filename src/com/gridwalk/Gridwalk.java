package com.gridwalk;

import java.util.*;
import java.lang.Math;

public class Gridwalk {
	
	// List to iterate over all reachable locations. Map determines if location is visited.
	static List<Location> reachables = new LinkedList<Location>();
	static Map<Location, Boolean> visited = new HashMap<Location, Boolean>();
	
	// Standard 2D-coordinates class.
	static class Location {
		int x, y;
		
		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Object in) {
			Location arg = (Location) in;
			if (arg == null) return false;
			return (x == arg.x && y == arg.y);
		}
		
		public int hashCode() {
			return this.x + this.y;
		}
	}
	
	// Mark location as visited and add adjacent locations if they are newly found and accessible/reachable.
	void visit(Location loc) {
		visited.put(loc, true);
		
		Location left = new Location(loc.x - 1, loc.y);
		Location right = new Location(loc.x + 1, loc.y);
		Location up = new Location(loc.x, loc.y + 1);
		Location down = new Location(loc.x, loc.y - 1);
		
		addIfNewAccessibleLocation(left);
		addIfNewAccessibleLocation(right);
		addIfNewAccessibleLocation(down);
		addIfNewAccessibleLocation(up);
	}
	
	// Add accessible location to reachable list if not already in reachable list.
	void addIfNewAccessibleLocation(Location loc) {
		if (!visited.containsKey(loc) && isAccessible(loc)) {
			reachables.add(loc);
			visited.put(loc, false);
		}
	}
	
	// Condition for whether or not a 2D location is accessible.
	boolean isAccessible(Location loc) {
		return (sumDigits(loc.x) + sumDigits(loc.y) <= 19);
	}
	
	// Method which sums the digits of a number.
	int sumDigits(int n) {
		if (n == 0) return 0;
		n = Math.abs(n);
		return (n % 10) + sumDigits(n / 10);
	}
	
	// Initialize reachable list with starting position.
	// Continually add reachable locations adjacent to already-added reachable locations.
	public static void main(String[] args) {
		long st = new Date().getTime();
		Gridwalk gw = new Gridwalk();
		Location start = new Location(0, 0);
		reachables.add(start);
		
		int index = 0;
		while (true) {
			if (index >= reachables.size())
				break;
			gw.visit(reachables.get(index));
			index++;
		}
		System.out.println(reachables.size());
		long et = new Date().getTime();
	}
	
}