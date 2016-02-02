package com.matchstrings;

public class StringMatch {

	public static void main(String[] args) {
		String string1 = "4cbcea9764b6b657d2147645eeb5b973b642530e";
		String string2 = "4cbcea9764b6b657d2147645eeb5b973b642530e";
		boolean sensitive = true;
		if (string1.trim().equalsIgnoreCase(string2.trim()) && !sensitive) {
			System.out.println("Dude strings are matching !! Nonsensitive Match !!");
		} else if (string1.trim().equals(string2.trim())) {
			System.out.println("Dude strings are matching !! Sensitive match");
		} else {
			System.out.println("Dude strings not matched !!");
		}
	}

}
