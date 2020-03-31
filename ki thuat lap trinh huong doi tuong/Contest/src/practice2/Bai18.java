package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Bai18 { // ngan xep
	Scanner sc = new Scanner(System.in);
	Stack<Integer> stack = new Stack<>();
	String str;
	int n;
	void solution() {
		while (sc.hasNext()) {
			str = sc.next();
			if (str.isEmpty()) {
				return;
			}
			if (str.equals("push")) {
				n = sc.nextInt();
				stack.push(n);
			}
			if (str.equals("pop")) {
				stack.pop();
			}
			if (str.equals("show")) {
				if (stack.isEmpty()) {
					System.out.println("empty");
				} else {
					for (int i = 0; i < stack.size(); i++) {
						System.out.print(stack.get(i) + " ");
					}
					System.out.println();
				}

			}

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai18 bai18 = new Bai18();
		bai18.solution();
	}

}
