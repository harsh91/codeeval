package com.matchstrings;

public class CountWords {

	public static void main(String[] args) throws Exception {
		String line = "In this chapter we look at how to analyze the cost of algorithms in a way that is useful for"
				+ "comparing algorithms to determine which is likely to be better, at least for large input sizes, but"
				+ "is abstract enough that we don’t have to look at minute details of compilers and machine"
				+ "architectures. There are a several parts of such analysis. Firstly we need to abstract the cost from"
				+ "details of the compiler or machine. Secondly we have to decide on a concrete model that allows"
				+ "us to formally define the cost of an algorithm. Since we are interested in parallel algorithms, the"
				+ "model needs to consider parallelism. Thirdly we need to understand how to analyze costs in this"
				+ "model. These are the topics of this chapter.";
		System.out.println(countWords(line));
	}

	public static int countWords(String s) {

		int wordCount = 0;

		boolean word = false;
		int endOfLine = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {
			// if the char is a letter, word = true.
			if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
				word = true;
				// if char isn't a letter and there have been letters before,
				// counter goes up.
			} else if (!Character.isLetter(s.charAt(i)) && word) {
				wordCount++;
				word = false;
				// last word of String; if it doesn't end with a non letter, it
				// wouldn't count without this.
			} else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
				wordCount++;
			}
		}
		return wordCount;
	}

}