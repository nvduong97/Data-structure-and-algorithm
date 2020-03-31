package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChessRook {
	static int[][] Matrix;
	static int[][] visit;
	static int n, max;

	static boolean isSafe(int x, int y) {

		if (Matrix[x][y] == 2) {
			return false;
		}
		for (int i = x - 1; i >= 0; i--) {
			if (Matrix[i][y] != 2) {
				if (visit[i][y] == 1) {
					return false;
				}
			} else {
				break;
			}
		}
		for (int i = y - 1; i >= 0; i--) {
			if (Matrix[x][i] != 2) {
				if (visit[x][i] == 1) {
					return false;
				}
			} else {
				break;
			}
		}
		return true;
	}

	static void deQuy(int x, int y) {
		// dieu kien dung
		int xNext;
		int yNext;
		if (x == n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (visit[i][j] == 1) {
						sum++; // dem vi tri quan xe dat
					}
				}
			}
			if (sum > max) {
				max = sum;
			}
			return;
		}
		for (int slc = 1; slc <= 2; slc++) {
			if (slc == 1) {
				if (isSafe(x, y)) { // dat
					visit[x][y] = 1;
					if (y == n - 1) {
						xNext = x + 1;
						yNext = 0;
					} else {
						xNext = x;
						yNext = y + 1;
					}
					deQuy(xNext, yNext);
					visit[x][y] = 0;
				}
			}
			if (slc == 2) { // khong dat
				if (y == n - 1) {
					xNext = x + 1;
					yNext = 0;
				} else {
					xNext = x;
					yNext = y + 1;
				}
				deQuy(xNext, yNext);
			}
		}

	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("ChessRook.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		int i, j, t, tc;
		t = sc.nextInt();
		for (tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			String[] s = new String[n + 1];
			// khai báo thừa thãi hay bị time out chỗ này
			Matrix = new int[5][5];
			visit = new int[5][5];

			for (i = 0; i < n; i++) {
				s[i] = sc.next();
			}
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					if (s[i].charAt(j) == 'X') {
						Matrix[i][j] = 2;
					} else {
						Matrix[i][j] = 0;
					}
				}
			}
			max = 0;
			deQuy(0, 0);
			System.out.println("Case #" + tc);
			System.out.println(max);
		}
	}

}
