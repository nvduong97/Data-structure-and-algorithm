package practice3;

import java.util.Arrays;
import java.util.Scanner;

public class b9 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int n = in.nextInt();
		int m = in.nextInt();
		while (t-- > 0) {
			int[][] a = new int[n][m];
			int[][] c = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					a[i][j] = in.nextInt();
				}
			}

			// tinh canh ngang tren cung
			int sum = 0;
			for (int i = 0; i < m; i++) {
				c[0][i] = sum + a[0][i];
				sum = c[0][i];
			}

			// tinh canh doc ngoai cung
			sum = 0;
			for (int i = 0; i < n; i++) {
				c[i][0] = sum + a[i][0];
				sum = c[i][0];
			}

			for (int i = 1; i < n; i++) {
				for (int j = 1; j < m; j++) {
					c[i][j] = a[i][j] + Math.min(Math.min(c[i - 1][j - 1], c[i][j - 1]), c[i - 1][j]);
				}
			}
			System.out.println(c[n - 1][m - 1]);
		}
	}

}