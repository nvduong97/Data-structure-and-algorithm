package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class KiemTraDayNgoacDung {
	Scanner sc = new Scanner(System.in);
	int t;
	String str;

	void solution() {
		t = sc.nextInt();
		sc.nextLine();
		while (t-- > 0) {
			str = sc.nextLine();
			Stack<Character> stack = new Stack<>();
			boolean check = true;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{') {
					stack.push(str.charAt(i));
				} else if (str.charAt(i) == ']') {
					if (!stack.empty()) {
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							check = false;
							break;
						}
					}
				} else if (str.charAt(i) == ')') {
					if (!stack.empty()) {
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							check = false;
							break;
						}
					}
				} else if (str.charAt(i) == '}') {
					if (!stack.empty()) {
						if (stack.peek() == '{') {
							stack.pop();
						} else {
							check = false;
							break;
						}
					}
				}
			}
			if (check == false || !stack.empty()) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		KiemTraDayNgoacDung kiemTraDayNgoacDung = new KiemTraDayNgoacDung();
		kiemTraDayNgoacDung.solution();
	}

}
