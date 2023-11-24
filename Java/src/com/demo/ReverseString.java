package com.demo;

public class ReverseString {

    public static String reverseSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split("\\s+");
        StringBuilder reversedSentence = new StringBuilder();

        for (String word : words) {
            StringBuilder reversedWord = new StringBuilder(word).reverse();
            reversedSentence.append(reversedWord).append(" ");
        }

        return reversedSentence.toString().trim();
    }

    public static void main(String[] args) {
        String inputSentence = "Hello world!";
        String reversedSentence = reverseSentence(inputSentence);
        System.out.println("Original: " + inputSentence);
        System.out.println("Reversed: " + reversedSentence);
    }
}