package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
/*
 * 3
{()}}}
[()]{}{[()()]()}
[(])
 */

public class Bai20 { // kiem tra day ngoac dung
	Scanner sc = new Scanner(System.in);
	int t;
	String s;
	void solution() {
		t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			Stack<Character> stack = new Stack<>();
			s = sc.next();
			boolean check = true;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
					stack.push(s.charAt(i));
				}
				if (s.charAt(i) == ']') {
					if (!stack.isEmpty()) {
						if (stack.peek() == '[') {
							stack.pop();
						}
					} else {
						check = false;
						break;
					}
				}
				if (s.charAt(i) == ')') {
					if (!stack.isEmpty()) {
						if (stack.peek() == '(') {
							stack.pop();
						}
					} else {
						check = false;
						break;
					}
				}
				if (s.charAt(i) == '}') {
					if (!stack.isEmpty()) {
						if (stack.peek() == '{') {
							stack.pop();
						}
					} else {
						check = false;
						break;
					}
				}

			}
			if (check == false) {
				System.out.println("NO");
			} else if (!stack.isEmpty()) {
				System.out.println("NO");
			} else if (stack.isEmpty()) {
				System.out.println("YES");
			}

		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai20 bai9 = new Bai20();
		bai9.solution();
	}

}
