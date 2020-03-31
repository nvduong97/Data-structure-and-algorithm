package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class NganXep {
	Scanner sc = new Scanner(System.in);
	String s;
	int n;
	Stack<Integer> stack = new Stack<>();

	void solution() {
		while (sc.hasNext()) {
			s = sc.next();
			if (s.equals("push")) {
				n = sc.nextInt();
				stack.add(n);
			}
			if (s.equals("show")) {
				for (int i = 0; i < stack.size(); i++) {
					System.out.print(stack.get(i) + " ");
				}
				System.out.println();
			}
			if (s.equals("pop")) {
				stack.pop();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		NganXep nganXep = new NganXep();
		nganXep.solution();
	}

}
