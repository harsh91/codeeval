package com.skyscrapers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Sky {
    
    class HeightLine {
        int height; //negative if it is the left height line; positive if it is the right height line
        int index;
        public HeightLine(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    
    public static void main(String args[]) {
    	int[][] buildings = {{1,2,3},{2,4,6},{4,5,5},{7,3,11},{9,2,14},{13,7,15},{14,3,17}};
    	List<int[]> list = new Sky().getSkyline(buildings);
    	for(int[] arr : list) {
    		System.out.println(arr.length);
    		System.out.println(arr[0]);
    		System.out.println(arr[1]);
    	}
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        if (buildings.length == 0) {
            return res;
        }
        int p = 0;
        int q = buildings.length - 1;
        return recurSkyline(buildings, p, q);
    }

    // construct sky line for buildings[p : q]
    private static LinkedList<int[]> recurSkyline(int[][] buildings, int p, int q) {
        if (p == q) {
            LinkedList<int[]> skyline = new LinkedList<>();
            skyline.add(new int[] { buildings[p][0], buildings[p][2] });
            skyline.add(new int[] { buildings[p][1], 0 });
            return skyline;
        } else {
            int mid = p + (q - p) / 2;
            return merge(recurSkyline(buildings, p, mid), recurSkyline(buildings, mid + 1, q));
        }
    }

    // merge sky line 1 and sky line 2
    private static LinkedList<int[]> merge(LinkedList<int[]> s1, LinkedList<int[]> s2) {
        LinkedList<int[]> res = new LinkedList<>();
        int h1 = 0; // height from s1
        int h2 = 0; // height from s2
        while (s1.size() > 0 && s2.size() > 0) {
            // key point is { x, h }
            int x = 0; int h = 0;
            if (s1.getFirst()[0] < s2.getFirst()[0]) {
                x = s1.getFirst()[0];
                h1 = s1.getFirst()[1];
                h = Math.max(h1, h2);
                s1.removeFirst();
            } else if (s1.getFirst()[0] > s2.getFirst()[0]) {
                x = s2.getFirst()[0]; 
                h2 = s2.getFirst()[1];
                h = Math.max(h1, h2);
                s2.removeFirst();
            } else {
                x = s1.getFirst()[0];
                h1 = s1.getFirst()[1];
                h2 = s2.getFirst()[1];
                h = Math.max(h1, h2);
                s1.removeFirst();
                s2.removeFirst();
            }
            if (res.size() == 0 || h != res.getLast()[1]) {
                // ignore key points that at the same level
                res.add(new int[] { x, h });
            }
        }
        res.addAll(s1);
        res.addAll(s2);
        return res;
    }
}