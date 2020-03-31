package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai27 { // duong di ngan nhat
	Scanner sc = new Scanner(System.in);
	int n, m, a, b, c, q, start, end;
	int map[][];
	int trongSo[][];

	void init() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) {
					trongSo[i][j] = 0;
				} else {
					trongSo[i][j] = 1000000007;
				}
			}
		}
	}

	void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (trongSo[i][j] > trongSo[i][k] + trongSo[k][j]) {
						trongSo[i][j] = trongSo[i][k] + trongSo[k][j];
					}
				}
			}
		}
	}

	void solution() {
		n = sc.nextInt();
		m = sc.nextInt();
		trongSo = new int[n + 1][n + 1];
		init();
		for (int i = 1; i <= m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			trongSo[a][b] = trongSo[b][a] = c;
		}
		floyd();
		q = sc.nextInt();
		while (q-- > 0) {
			start = sc.nextInt();
			end = sc.nextInt();
			System.out.println(trongSo[start][end]);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai27 bai27 = new Bai27();
		bai27.solution();

	}

}
