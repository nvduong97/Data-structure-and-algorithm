package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class XoaChuSo {
	Scanner sc = new Scanner(System.in);
	int n, k;
	String str;
	Stack<Integer> stack = new Stack<>();

	void solution() {
		n = sc.nextInt();
		k = sc.nextInt();
		sc.nextLine();
		str = sc.nextLine();
		System.out.println(n+" "+k+" "+str);
		for (int i = 0; i < n; i++) {
			//System.out.println(str.charAt(i));
			int c = str.charAt(i) - '0';
			while (!stack.empty() && c > stack.peek() && k > 0) {
				k--;
				stack.pop();
			}
			stack.push(c);
		}
		for(int i=0; i<stack.size(); i++) {
			System.out.print(stack.get(i));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		XoaChuSo xoaChuSo = new XoaChuSo();
		xoaChuSo.solution();
	}

}
