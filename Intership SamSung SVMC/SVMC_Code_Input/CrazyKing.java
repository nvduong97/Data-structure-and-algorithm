package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 
 * https://alexishuuuocn.wordpress.com/2019/07/18/crazy-king/
 */
public class CrazyKing {
	static char[] str;
	static int t, n, m, answer, st, en;
	static int[][] map;
	static int[][] visit;
	static int[] dxVua = { 1, -1, 0, 0, 1, -1, 1, -1 };
	static int[] dyVua = { 0, 0, 1, -1, 1, -1, -1, 1 };

	static int[] dxMa = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dyMa = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static int[] queueX = new int[1000000];
	static int[] queueY = new int[1000000];

	static void backTrack(int startX, int startY) {
		st = 0;
		en = 0;
		queueX[en] = startX;
		queueY[en] = startY;
		en++;
		visit[startX][startY] = 1;
		while (st != en) {
			int x = queueX[st];
			int y = queueY[st];
			st++;
			for (int i = 0; i < 8; i++) {
				int xNext = x + dxVua[i];
				int yNext = y + dyVua[i];
				if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < m) {
					if (visit[xNext][yNext] == 0 && map[xNext][yNext] != 1) {
						queueX[en] = xNext;
						queueY[en] = yNext;
						en++;
						visit[xNext][yNext] = visit[x][y] + 1;
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("CrazyKing.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			// ma trận đảo lại kích thước mảng
			m = sc.nextInt();
			n = sc.nextInt();
			sc.nextLine();
			map = new int[n + 1][m + 1];
			visit = new int[n + 1][m + 1];
			String s = "";
			str = new char[m];
			int xA = 0, yA = 0, xB = 0, yB = 0;
			for (int i = 0; i < n; i++) {
				s = sc.nextLine();
				str = s.toCharArray();
				// String không đọc được từng ký tự một
				for (int j = 0; j < m; j++) {
					if (str[j] == 'A') {
						map[i][j] = 1000;
						xA = i;
						yA = j;
					}
					if (str[j] == 'B') {
						map[i][j] = 1000;
						xB = i;
						yB = j;
					}
					if (str[j] == 'Z') {
						map[i][j] = 1;
						visit[i][j] = -1;
					}
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						for (int k = 0; k < 8; k++) {
							int x = i + dxMa[k];
							int y = j + dyMa[k];
							if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] != 1000) {
								visit[x][y] = -1;
							}
						}
					}
				}
			}
			backTrack(xA, yA);
			// di tu A => B
			// quan ma khong an duoc 2 vi tri A, B
			if (visit[xB][yB] == 0) { // truong hop quan vua khong den duoc
				System.out.println(-1);
			} else {
				System.out.println(visit[xB][yB] - 1);
			}
		}
	}
}
