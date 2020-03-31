package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Bai9 { // duong di nho nhat
	Scanner sc = new Scanner(System.in);
	int n, m, t;
	int map[][], cost[][];
	void init() {
		map = new int[n][m];
		cost = new int[n][m];
	}
	long result() {
		cost[0][0] = map[0][0];
		for (int i = 1; i < n; i++) {
			cost[i][0] = cost[i - 1][0] + map[i][0];
		}
		for (int i = 1; i < m; i++) {
			cost[0][i] = cost[0][i - 1] + map[0][i];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				cost[i][j] = Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i][j - 1])) + map[i][j];
			}
		}
		return cost[n - 1][m - 1];
	}

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			init();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			System.out.println(result());
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai9 bai1 = new Bai9();
		bai1.solution();
	}

}
