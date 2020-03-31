package practice2;

import java.util.Stack;

public class Demo {

	public static void main(String[] args) {
		// two characters 
        char c1 = '(', c2 = '2'; 
  
        // Function to check if the character is letter or digit 
        boolean bool1 = Character.isLetterOrDigit(c1); 
        System.out.println(c1 + " is a letter/digit ? " + bool1); 
  
        // Function to check if the character is letter or digit 
        boolean bool2 = Character.isLetterOrDigit(c2); 
        System.out.println(c2 + " is a letter/digit ? " + bool2); 
	}

}
