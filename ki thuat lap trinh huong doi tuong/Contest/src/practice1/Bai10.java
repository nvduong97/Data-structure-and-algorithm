package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai10 {
	int testCase;
	Scanner sc = new Scanner(System.in);
	String s;
	boolean check1, check2, check3, check4;

	boolean soNguyenTo(int n) {
		if (n < 2)
			return false;
		else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0)
					return false;
			}
			return true;
		}
	}

	void solution() {
		testCase = Integer.parseInt(sc.nextLine());
		for (int tc = 0; tc < testCase; tc++) {
			check3 = true;
			check4 = true;
			s = sc.nextLine();
			// la so thuan nghich
			for (int i = 0; i < s.length() / 2; i++) {
				char str3 = s.charAt(i);
				char str4 = s.charAt(s.length() - 1 - i);
				int number1 = Character.getNumericValue(str3);
				int number2 = Character.getNumericValue(str4);
				if (number1 != number2) {
					check3 = false;
					break;
				}
			}
			// all la so nguyen to
			for (int i = 0; i < s.length(); i++) {
				char str1 = s.charAt(i);
				int number = Character.getNumericValue(str1);
				if (!soNguyenTo(number)) {
					check4 = false;
					break;
				}
			}
			if (check3 == false || check4 == false) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai10.txt"));
		Bai10 b = new Bai10();
		b.solution();
	}
}
