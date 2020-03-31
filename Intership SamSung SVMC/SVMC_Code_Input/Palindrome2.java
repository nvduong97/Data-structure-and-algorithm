package OnTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Tìm độ dài lớn nhất của xâu palindrome trong ma trận
 */
public class Palindrome2 {
	public static void main(String[] args) {
		// System.setIn(new FileInputStream("inputPalindrome2.txt"));
		Scanner sc = new Scanner(System.in);

		String A[];

		for (int tc = 1; tc <= 10; tc++) {
			int max = 0;

			tc = sc.nextInt();
			A = new String[100];
			for (int i = 0; i < 100; i++) {

				A[i] = sc.next();
			}
			// xét xâu palindrome có độ dài lần lượt là 1,2,3,...,100 để tìm xem có tồn tại xâu palindrome hay không, nếu có thì gán và so sánh, khác thì out luôn
			// bài này không khác là bao so với bài Palindome 1
			// tìm max độ dài của hàng
			for (int n = 1; n <= 100; n++) {
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j <= 100 - n; j++) {
						boolean check = true;
						for (int j2 = 0; j2 <= n / 2 - 1; j2++) {
							if (A[i].charAt(j + j2) != A[i].charAt(n + j - 1 - j2)) {
								check = false;
								break;
							}
						}
						if (check == true) {
							if (n > max) {
								max = n;
							}

						}
					}

				}
				// tìm max độ dài của cột
				for (int j = 0; j < 100; j++) {
					for (int i = 0; i <= 100 - n; i++) {
						boolean check = true;
						for (int i2 = 0; i2 <= n / 2 - 1; i2++) {
							if (A[i2 + i].charAt(j) != A[n + i - 1 - i2].charAt(j)) {
								check = false;
								break;
							}
						}
						if (check == true) {
							if (n > max) {
								max = n;
							}

						}
					}
				}

			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
