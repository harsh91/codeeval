package com.gridwalk;

import java.util.*;
import java.lang.Math;

class grid {
	
	
	static List<Lap> reachables_second = new LinkedList<Lap>();
	static Map<Lap, Boolean> visited_sec = new HashMap<Lap, Boolean>();
	
	
	static class Lap {
		int a,b;
		
		Lap(int a, int b) {
			this.a = a;
			this.b = b;
		}
		
		
		public boolean equalality(Object ob) {
			Lap argument = (Lap) ob;
			if (argument == null)
				return false;
			
			return (a == argument.a && b == argument.b);
		}
		public int hashCode() {
			return this.a + this.b;
		}
		
		
	}
	void visit(Lap location) {
		visited_sec.put(location, true);
		
		Lap le = new Lap(location.a - 1, location.b);
		Lap ri = new Lap(location.a + 1, location.b);
		Lap up = new Lap(location.a, location.b + 1);
		Lap down2 = new Lap(location.a, location.b - 1);
		
		NewAccessible(le);
		NewAccessible(ri);
		NewAccessible(down2);
		NewAccessible(up);
	}
	
	void NewAccessible(Lap loc) {
		if (!visited_sec.containsKey(loc) && isAccessiblity(loc)) {
			reachables_second.add(loc);
			visited_sec.put(loc, false);
		}
	}
	
	boolean isAccessiblity(Lap loc) {
		return (sum(loc.a) + sum(loc.b) <= 19);
	}
	
	
	
	
	

	int sum(int m) {
		if (m == 0)
			return 0;
			
			
		m = Math.abs(m);
		return (m % 10)+ sum(m / 10);
	}

	
	
	public static void main(String[] args) {
		int var = 0;
		grid op = new grid();
		Lap start = new Lap(0, 0);
		reachables_second.add(start);
		
		
		while (true) {
			if (var >= reachables_second.size())
				break;
			op.visit(reachables_second.get(var));
			var++;
		}
		System.out.println(reachables_second.size());
	}
	
}