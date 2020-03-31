package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class XauConChungDaiNhat {
	Scanner sc = new Scanner(System.in);
	String s1, s2;
	int c[][];

	void solution() {
		s1 = sc.nextLine();
		s2 = sc.nextLine();
		int n1 = s1.length();
		int n2 = s2.length();
		c = new int[n1 + 1][n2 + 1];
		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					c[i + 1][j + 1] = c[i][j] + 1;
				} else {
					c[i + 1][j + 1] = Math.max(c[i + 1][j], c[i][j + 1]);
				}
			}
		}

//		for (int i = 0; i <= n1; i++) {
//			for (int j = 0; j <= n2; j++) {
//				System.out.print(c[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(c[n1][n2]);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		XauConChungDaiNhat xauConChungDaiNhat = new XauConChungDaiNhat();
		xauConChungDaiNhat.solution();
	}

}
