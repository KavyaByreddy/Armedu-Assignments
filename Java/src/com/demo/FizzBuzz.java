package com.demo;

public class FizzBuzz {
	
	public static void main(String[] args) {
		
		 fizzBuzz(1, 100);
	      testFizzBuzz();
	}
	public static void fizzBuzz(int start, int end) {
        if (start <= 0 || end <= 0 || start > end) {
            System.out.println("Invalid input. Start and end values must be positive, and start should be less than or equal to end.");
            return;
        }

		
		for(int i=0;i<=100;i++) {
			if(i%3==0 && i%5==0) {
				System.out.println("FizzBuzz");
			}
			else if(i%5==0) {
				System.out.println("Buzz");
			}
			else if(i%3==0) {
				System.out.println("Fizz");
			}
			else {
				System.out.println(i);
			}
		}
	}
	  public static void testFizzBuzz() {
	        
	        fizzBuzz(1, 15);

	      
	        fizzBuzz(20, 10);

	        
	        fizzBuzz(-5, 5);

	       
	        fizzBuzz(9, 12);

	       
	        fizzBuzz(20, 25);

	        fizzBuzz(15, 30);
	    }

}