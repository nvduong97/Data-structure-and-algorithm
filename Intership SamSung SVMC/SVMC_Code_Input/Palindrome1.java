package OnTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Tìm xem có bao nhiêu xâu palindrome có độ dài n trong ma trận 8x8 (dọc và ngang)
 * Và cách giải vẫn là for - trâu + vs chút Array + String
 */
public class Palindrome1 {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("Palindrome1.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		int i, j, tc, stt, n;
		for (tc = 1; tc <= 10; tc++) {
			String s[] = new String[8];
			// n = Integer.parseInt(sc.nextLine());
			String m = sc.next();
			n = Integer.parseInt(m);
			for (i = 0; i < 8; i++) {
				s[i] = sc.next();
			}
			int count = 0;
			// hàng ngang
			for (i = 0; i < 8; i++) {
				for (j = 0; j <= 8 - n; j++) {
					boolean check = true;
					for (int x = 0; x < n / 2; x++) {
						if (s[i].charAt(j + x) != s[i].charAt(n - 1 + j - x)) {
							check = false;
							break;
						}
					}
					if (check) {
						count++;
					}
				}
			}
			// hàng dọc
			for (i = 0; i < 8; i++) {
				for (j = 0; j <= 8 - n; j++) {
					boolean check = true;
					for (int x = 0; x < n / 2; x++) {
						if (s[j + x].charAt(i) != s[n - 1 + j - x].charAt(i)) {
							check = false;
							break;
						}
					}
					if (check) {
						count++;
					}
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}

}
