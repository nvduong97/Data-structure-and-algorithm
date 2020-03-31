package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Chính ra đề không khó, vẫn đề là dài khiến lười ko muốn đọc
 */
public class Hugo2 {
	Scanner sc = new Scanner(System.in);
	int t, n, m, SR, SC, k, x, y, st, en, answer, nextTime;
	int map[][], fire[][], diamond[][], visit[][];
	int queueX[] = new int[1000000];
	int queueY[] = new int[1000000];
	int dx[] = { 1, -1, 0, 0 };
	int dy[] = { 0, 0, 1, -1 };

	void init() {
		// nếu Hugo ko thể thoát khỏi khu rừng in ra -1
		answer = -1;
		map = new int[n + 1][m + 1];
		fire = new int[n + 1][m + 1];
		diamond = new int[n + 1][m + 1];
		visit = new int[n + 1][m + 1];
		st = en = 0;
	}

	void BFS() {
		while (st != en) {
			int xx = queueX[st];
			int yy = queueY[st];
			st++;
			for (int i = 0; i < 4; i++) {
				int xNext = xx + dx[i];
				int yNext = yy + dy[i];
				if (xNext >= 1 && xNext <= n && yNext >= 1 && yNext <= m) {
					if (fire[xNext][yNext] == 10000) {
						if (map[xNext][yNext] <= 1) {
							fire[xNext][yNext] = fire[xx][yy] + 1;
							// lửa lan đều
							queueX[en] = xNext;
							queueY[en] = yNext;
							en++;
						}
					}
				}
			}
		}
	}

	void solve(int xx, int yy, int time, int score) {
		visit[xx][yy] = 1;
		// tất nhiên là nếu ko đi tới exit được thì Hugo ko thể thoát khởi map nên in ra
		// -1
		if (map[xx][yy] == 1 || map[xx][yy] == 4) {
			if (score > answer) {
				answer = score;
			}
			// bài này là vét cạn, ko có điều kiện dừng (return) vì map có nhiều lối thoát,
			// chưa chắc đi vào lối thoát đầu tiên mà hugo có thể nhặt được nhiều kim cương
			// nhất
		}
		for (int i = 0; i < 4; i++) {
			int xNext = xx + dx[i];
			int yNext = yy + dy[i];
			if (xNext >= 1 && xNext <= n && yNext >= 1 && yNext <= m) {
				if (visit[xNext][yNext] == 0) {
					if (map[xNext][yNext] <= 1) {
						nextTime = time + 1;
					}
					if (map[xNext][yNext] > 1) {
						nextTime = time + 2;
					}
					// nếu thời gian hugo nhảy nhanh hơn thời gian lửa lan tới
					if (nextTime < fire[xNext][yNext]) {
						solve(xNext, yNext, nextTime, score + diamond[xNext][yNext]);
					}
				}
			}
		}
		visit[xx][yy] = 0;
	}

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			SR = sc.nextInt();
			SC = sc.nextInt();
			init();

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					fire[i][j] = 10000;
				}
			}
			k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				fire[x][y] = 0;
				queueX[en] = x;
				queueY[en] = y;
				en++;
			}
			System.out.println("fire");
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					System.out.print(fire[i][j] + " ");
				}
				System.out.println();
			}
			k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				map[x][y] = 2;
			}
			k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				if (map[x][y] == 2) {
					map[x][y] = 4;
				} else {
					map[x][y] = 1;
				}
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					diamond[i][j] = sc.nextInt();
				}
			}
			// BFS lua lan
			BFS();
			System.out.println("fire");
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					System.out.print(fire[i][j] + " ");
				}
				System.out.println();
			}
			// hugo run
			solve(SR, SC, 0, diamond[SR][SC]);
			System.out.println("Case #" + tc);
			System.out.println(answer);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Hugo.txt"));
		Hugo2 h = new Hugo2();
		h.solution();
	}

}
