package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai8 {
	int testCase;
	Scanner sc = new Scanner(System.in);
	String s;
	boolean check, check2;
	void solution() {
		testCase = Integer.parseInt(sc.nextLine());
		while(testCase-- > 0) {
			check = true;
			check2 = true;
			s = sc.nextLine();
			for(int i=0; i<s.length(); i++) {
				char str = s.charAt(i);
				int n = Character.getNumericValue(str);
				if(n % 2 == 1) {
					check = false;
					break;
				}
			}
			for(int i=0; i<s.length()/2; i++) {
				char str1 = s.charAt(i);
				char str2 = s.charAt(s.length()-1-i);
				int number1 = Character.getNumericValue(str1);
				int number2 = Character.getNumericValue(str2);
				if(number1 != number2) {
					check2 = false;
					break;
				}
			}
			if(check == false || check2 == false) {
				System.out.println("NO");
			}
			else {
				System.out.println("YES");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai8.txt"));
		Bai8 b = new Bai8();
		b.solution();
	}
}
