package com.longestrepeatedsubstring;

public class LRS {

    // return the longest common prefix of s and t
    public static String lcp(String s, String t) {
        int n = Math.min(s.length(), t.length());
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i))
                return s.substring(0, i);
        }
        return s.substring(0, n);
    }


    // return the longest repeated string in s
    public static String lrs(String text) {

    	String longest = "";
        for (int i = 0; i < text.length() - 2 * longest.length() * 2; i++) {
            OUTER:
            for (int j = longest.length() + 1; j * 2 < text.length() - i; j++) {
                String find = text.substring(i, i + j);
                for (int k = i + j; k <= text.length() - j; k++) {
                    if (text.substring(k, k + j).equals(find)) {
                        longest = find;
                        continue OUTER;
                    }
                }
                break;
            }
        }
        return longest;
    }



    // read in text, replacing all consecutive whitespace with a single space
    // then compute longest repeated substring
    public static void main(String[] args) {
    	String longest = lrs("am so unique");
    	
        if(longest.trim().length() > 0) {
        	System.out.println(longest);
        } else {
        	System.out.println("No match");
        }
    }
}