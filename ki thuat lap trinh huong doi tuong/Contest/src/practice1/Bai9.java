package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// để break vô tội vạ
public class Bai9 {
	int testCase;
	Scanner sc = new Scanner(System.in);
	String s;
	boolean check1, check2, check3, check4;

	void solution() {
		testCase = Integer.parseInt(sc.nextLine());
		for (int tc = 0; tc < testCase; tc++) {
			check1 = true;
			check2 = true;
			check3 = true;
			check4 = true;
			s = sc.nextLine();
			// bat dau bang so 8
			char str1 = s.charAt(0);
			int nStart = Character.getNumericValue(str1);
			if (nStart != 8) {
				check1 = false;
				// break;
			}
			// ket thuc bang so 8
			char str2 = s.charAt(0);
			int nEnd = Character.getNumericValue(str2);
			if (nEnd != 8) {
				check2 = false;
				// break;
			}
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
			// tong cac chu so chia het cho 10
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				char str4 = s.charAt(i);
				int number3 = Character.getNumericValue(str4);
				sum += number3;
			}
			if (sum % 10 != 0) {
				check4 = false;
				// break;
			}
			if (check1 == false || check2 == false || check3 == false || check4 == false) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai9.txt"));
		Bai9 b = new Bai9();
		b.solution();
	}
}
