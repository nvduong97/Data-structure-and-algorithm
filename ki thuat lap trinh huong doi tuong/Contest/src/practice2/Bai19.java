package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
public class Bai19 { // bieu thuc hau to
	Scanner sc = new Scanner(System.in);
	int t;
	String str;
	Stack<Character> stack = new Stack<>();

	int danhDau(char c) {
		if (c == '+' || c == '-')
			return 1;
		if (c == '*' || c == '/')
			return 2;
		return -1;
	}

	void solution() {
		t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			str = sc.nextLine();
			String result = new String();
			for (int i = 0; i < str.length(); i++) {
				char character = str.charAt(i);
				if (character == '(') {
					stack.push(character);
				} else if (Character.isLetterOrDigit(character)) {
					result += character;
				}
				// if is operator
				else if (character == '+' || character == '-' || character == '*' || character == '/') {
					while (!stack.isEmpty() && danhDau(character) <= danhDau(stack.peek())) {
						result+=stack.pop();
					}
					stack.push(character);
				} else if (character == ')') {
					while (!stack.isEmpty() && stack.peek() != '(') {
						result += stack.pop();
					}
					stack.pop();
				}

			}
			while (!stack.isEmpty()) {
				result += stack.pop();
			}
			System.out.println(result);
			stack.clear();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai19 bai19 = new Bai19();
		bai19.solution();

	}
}
