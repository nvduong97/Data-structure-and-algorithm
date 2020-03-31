package thi_ktlthdt;
import java.util.*;
public class Bai14 {
    static boolean isOperator(char x) { 
	switch (x) { 
		case '+': 
		case '-': 
		case '/': 
		case '*': 
			return true; 
		} 
		return false; 
	} 

    static String postToPre(String post_exp) { 
		Stack<String> s = new Stack<String>(); 
		int length = post_exp.length(); 
		for (int i = 0; i < length; i++) { 
			if (isOperator(post_exp.charAt(i))) { 
				String op1 = s.peek(); 
				s.pop(); 
				String op2 = s.peek(); 
				s.pop(); 
				String temp = post_exp.charAt(i) + op2 + op1; 
				s.push(temp); 
			} 
			else { 
				s.push(post_exp.charAt(i) + ""); 
			} 
		} 
		return s.peek(); 
    } 
    public static void main(String args[]) 	{ 
	Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String s = sc.next();
            System.out.println(postToPre(s));
        }
    } 
}