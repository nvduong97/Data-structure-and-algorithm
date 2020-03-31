package luyentap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class MarioClimb {
	Scanner sc = new Scanner(System.in);
	int t, n, m, st, en;
	int map[][], visit[][];
	int x2 = 0, y2 = 0, x3 = 0, y3 = 0;
	int queueX[] = new int[1000000];
	int queueY[] = new int[1000000];
	int dx[] = { 1, -1, 0, 0 };
	int dy[] = { 0, 0, 1, -1 };

	void init() {
		map = new int[n][m];
		visit = new int[n][m];
	}

	// void backTrack(int h) : backTrack thế này hay ở dưới đều ok
	void backTrack(int startX, int startY, int h) {
		st = en = 0;
		queueX[en] = startX;
		queueY[en++] = startY;
		visit[x2][y2] = 1;
		while (st != en) {
			int x = queueX[st];
			int y = queueY[st++];
			if (x == x3 && y == y3) {
				System.out.println(h);
				return;
			}
			for (int i = 0; i < 4; i++) {
				// di doc
				if (i == 0 || i == 1) {
					int count = 0;
					while (h > count) {
						count++;
						int a = x + dx[i] * count;
						int b = y + dy[i];
						if (a >= 0 && a < n && b >= 0 && b < m) {
							if (visit[a][b] == 0 && map[a][b] != 0) {
								queueX[en] = a;
								queueY[en++] = b;
								visit[a][b] = 1;
							}
						}
					}
				}
				// di ngang
				else if (i == 2 || i == 3) {
					int a = x + dx[i];
					int b = y + dy[i];
					if (a >= 0 && a < n && b >= 0 && b < m) {
						if (visit[a][b] == 0 && map[a][b] != 0) {
							queueX[en] = a;
							queueY[en++] = b;
							visit[a][b] = 1;
						}
					}
				}
			}
		}
		resetVisit();
		backTrack(startX, startY, h + 1);
	}

	void resetVisit() {
		visit = new int[n][m];
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
					if (map[i][j] == 2) {
						x2 = i;
						y2 = j;
					} else if (map[i][j] == 3) {
						x3 = i;
						y3 = j;
					}
				}
			}
			System.out.println("Case #" + tc);
			backTrack(x2, y2, 0);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("MarioClimb.txt"));
		MarioClimb m = new MarioClimb();
		m.solution();
	}

}
