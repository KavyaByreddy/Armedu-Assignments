package com.demo;

public class StringPermutation {

	public static void main(String[] args) {
	
		String input="ABC";
		
		printPermutations(input);
	}

	public static void printPermutations(String str) {
		
		if(str==null || str.isEmpty()) {
			System.out.println("String is empty");
			return;
		}
		
		generatePermutations("", str);
	}

	public static void generatePermutations(String string, String remaining) {
		
		if(remaining.isEmpty()) {
			System.out.println(string);
		}
		for (int i = 0; i < remaining.length(); i++) {
            char currentChar = remaining.charAt(i);
            generatePermutations(string + currentChar, remaining.substring(0, i) + remaining.substring(i + 1));
	}
	
	}

}