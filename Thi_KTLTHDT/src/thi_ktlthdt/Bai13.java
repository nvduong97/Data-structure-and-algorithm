package thi_ktlthdt;
import java.util.*;
public class Bai13 {
    static boolean isOperator(char x) { 
	switch (x){ 
		case '+': 
		case '-': 
		case '/': 
		case '*': 
		return true; 
	} 
	return false; 
    } 
    static String preToPost(String pre_exp) { 
	Stack<String> s= new Stack<String>(); 
	int length = pre_exp.length(); 
	for (int i = length - 1; i >= 0; i--) { 
		if (isOperator(pre_exp.charAt(i))) { 
			String op1 = s.peek(); s.pop(); 
			String op2 = s.peek(); s.pop(); 
			String temp = op1 + op2 + pre_exp.charAt(i); 
			s.push(temp); 
		} 
		else	{ 
			s.push( pre_exp.charAt(i)+""); 
		} 
	} 
	return s.peek(); 
    } 
    public static void main(String args[]) { 
	Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            String s = sc.next();
            System.out.println(preToPost(s));
        }
    } 
} 
