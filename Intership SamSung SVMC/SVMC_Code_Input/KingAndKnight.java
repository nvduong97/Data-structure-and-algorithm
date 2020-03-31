package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * đề cho ma trận nxn.
 * Cho 1 quân vua ở 1 vị trí trong bản đồ, quân vua có thể đi thẳng, đi ngang 1 ô, có thể đi chéo 1 ô
 * có k quân mã đang ở trên bản đồ, quân mã có thể ăn chéo. Khi quân king đi rồi thì ko đi lại được nữa
 * Xác định số bước đi của quân vua tới vị trí (s,t) sao cho ko đi vào vị trí quân mã đang đứng và ko đi vào vị trí quân mã đang đứng có thể ăn được
 *  nếu ko được tới đích thì in ra -1
 */
public class KingAndKnight {
	Scanner sc = new Scanner(System.in);
	int testCase, n, a, b, k, x, y, s, t, st, en;
	int map[][];
	int visit[][];
	int queueX[];
	int queueY[];
	int dxMa[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	int dyMa[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	int dxVua[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
	int dyVua[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	void init() {
		map = new int[n + 1][n + 1];
		visit = new int[n + 1][n + 1];
		queueX = new int[1000000];
		queueY = new int[1000000];
	}

	void BFS(int startX, int startY) {
		st = en = 0;
		queueX[en] = startX;
		queueY[en] = startY;
		en++;
		visit[startX][startY] = 1;
		while (st != en) {
			int xn = queueX[st];
			int yn = queueY[st];
			st++;
			for (int i = 0; i < 8; i++) {
				int xNext = xn + dxVua[i];
				int yNext = yn + dyVua[i];
				if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < n) {
					if (visit[xNext][yNext] == 0) {
						if (map[xNext][yNext] != 1) {
							queueX[en] = xNext;
							queueY[en] = yNext;
							en++;
							visit[xNext][yNext] = visit[xn][yn] + 1;
						}
					}
				}
			}
		}
	}

	void DFS() {

	}

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			init();
			// vị trí quân vua trên bàn cờ
			a = sc.nextInt();
			b = sc.nextInt();
			map[a][b] = 10000;
			// vi tri dich
			s = sc.nextInt();
			t = sc.nextInt();
			map[s][t] = 10000;
			// k quân mã đang đứng trên bàn cờ
			// do quân mã có thể ăn được 4 phía nên ta đánh visit nó để vua ko đi tới được
			// điểm đó
			k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				map[x][y] = 1;
				visit[x][y] = -1;
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) {
						for (int l = 0; l < 8; l++) {
							int xn = i + dxMa[l];
							int yn = j + dyMa[l];
							if (xn >= 0 && xn < n && yn >= 0 && yn < n) {
								visit[xn][yn] = -1;
							}
						}
					}
				}
			}
			BFS(a, b);
			if (visit[s][t] == 0) {
				System.out.println(-1);
			} else {
				System.out.println(visit[s][t] - 1);
			}

		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("KingAndKnight.txt"));
		KingAndKnight k = new KingAndKnight();
		k.solution();
	}

}
