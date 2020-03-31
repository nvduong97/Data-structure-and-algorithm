package OnTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class PassWord2 {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("PassWord.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		int i,j,tc,n;
		for(tc=1; tc<=2; tc++) {
			Stack<Character> st = new Stack<Character>();
			n = sc.nextInt();
			char s[] = new char[n];
			s = sc.next().toCharArray();
			int count=0;
			for(i=n-1; i>=0; i--) {
				if(st.isEmpty()) {
					count++;
					st.push(s[i]);
				}
				else {
					char x = st.peek();
					if(x == s[i]) {
						count--;
						st.pop();
					}
					else {
						count++;
						st.push(s[i]);
					}
				}
			}
			System.out.print("#"+tc+" ");
			for(i=0; i<count; i++) {
				System.out.print(st.pop());
			}
			System.out.println();
		}
	}

}
