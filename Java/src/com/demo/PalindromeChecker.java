package com.demo;
import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String userInput = scanner.nextLine();

        if (isPalindrome(userInput)) {
            System.out.println(userInput + " is a palindrome.");
        } else {
            System.out.println(userInput + " is not a palindrome.");
        }

        testPalindromeChecker();
    }

    public static boolean isPalindrome(String s) {
       
        s = s.replaceAll("\\s", "").toLowerCase();

        
        if (s.length() <= 1) {
            return true;
        }
       
        else if (s.charAt(0) == s.charAt(s.length() - 1)) {
          
            return isPalindrome(s.substring(1, s.length() - 1));
        } else {
            return false;
        }
    }

    public static void testPalindromeChecker() {
      
        assert isPalindrome("rotor") == true;

        assert isPalindrome("civic") == true;
        
        assert isPalindrome("level") == true;

        assert isPalindrome("hello") == false;

        assert isPalindrome("") == true;

        assert isPalindrome("a") == true;

        assert isPalindrome("Race fast, safe car") == true;

        System.out.println("Task Completed");
    }
}