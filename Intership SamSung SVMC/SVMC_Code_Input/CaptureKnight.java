package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Trong bàn cờ vua, quân mã có thể ăn 8 vị trí xung quanh
 * Đếm số lần đi ít nhất để quân mã có thể ăn một quân bất kỳ trên bàn cờ
 * 0 - bàn cờ ko có gì
 * 1- vị trí quân đang đứng
 * 3 - vị trí quân mã
 */
public class CaptureKnight {
	Scanner sc = new Scanner(System.in);
	int t, n,m, st, en;
	int map[][], visit[][];
	int queueX[] = new int[1000000];
	int queueY[] = new int[1000000];
	int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };

	void BFS(int startX, int startY) {
		queueX[en] = startX;
		queueY[en] = startY;
		en++;
		visit[startX][startY] = 1;
		while (st != en) {
			int x = queueX[st];
			int y = queueY[st];
			st++;
			for (int i = 0; i < 8; i++) {
				int xNext = x + dx[i];
				int yNext = y + dy[i];
				if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < m) {
					if (visit[xNext][yNext] == 0) {
						if (map[xNext][yNext] != 2) {
							queueX[en] = xNext;
							queueY[en] = yNext;
							en++;
							visit[xNext][yNext] = visit[x][y] + 1;
						}
					}
				}
			}
		}
	}

	void init() {
		st = en = 0;
		map = new int[n + 1][m + 1];
		visit = new int[n + 1][m + 1];
	}

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			init();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 3) {
						BFS(i, j);
						break;
					}
				}
			}
			int viTriX = 0, viTriY = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 1) {
						viTriX = i;
						viTriY = j;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + (visit[viTriX][viTriY] - 1));
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("CaptureKnight.txt"));
		CaptureKnight c = new CaptureKnight();
		c.solution();
	}

}
