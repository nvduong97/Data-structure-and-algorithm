package luyentap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Chương trình của bạn sẽ đưa ra chi phí tối thiểu cuối cùng cho việc đi từ trại đến mỏ vàng.
 */
public class GoldMining {
	Scanner sc = new Scanner(System.in);
	int t, n, g, st, en;
	int gold[][], map[][], visit[][];
	int dx[] = { 0, 0, 1, -1 };
	int dy[] = { 1, -1, 0, 0 };
	int queueX[] = new int[1000000];
	int queueY[] = new int[1000000];

	void init() {
		gold = new int[g][2];
		map = new int[n][n];
		visit = new int[n][n];
	}

	void resetVisit() {
		visit = new int[n][n];
	}

	void resultVisit() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
	}

	void BFS(int startX, int startY) {
		st = en = 0;
		queueX[en] = startX;
		queueY[en++] = startY;
		visit[startX][startY] = 1;
		while (st != en) {
			int x = queueX[st];
			int y = queueY[st++];
			for (int i = 0; i < 4; i++) {
				int a = x + dx[i];
				int b = y + dy[i];
				if (a >= 0 && a < n && b >= 0 && b < n) {
					if (visit[a][b] == 0 && map[a][b] == 1) {
						queueX[en] = a;
						queueY[en++] = b;
						visit[a][b] = visit[x][y] + 1;
					}
				}
			}
		}
	}

	void input() {
		n = sc.nextInt();
		g = sc.nextInt();
		init();
		for (int i = 0; i < g; i++) {
			for (int j = 0; j < 2; j++) {
				gold[i][j] = sc.nextInt() - 1;
			}
		}
//		System.out.println("gold");
//		for (int i = 0; i < g; i++) {
//			for (int j = 0; j < 2; j++) {
//				System.out.print(gold[i][j]+" ");
//			}
//			System.out.println();
//		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//		System.out.println("map");
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}

	}

	// chắc vần đề ở chỗ trong hàm solution
	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			input();
			int min = 999999;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int max = 0;
					boolean check1 = true, check2 = false;
					// ko được đặt trại ở vị trí mỏ vàng, mỏ đá. Đặt trại mà 4 phía xung quanh là đá
					// thì ko đi được
					// 1 là mỏ vàng, or đường đi, 0 là mỏ đá ko đi được
					for (int v = 0; v < g; v++) {
						if (gold[v][0] == i && gold[v][1] == j) {
							check1 = false;
							break;
						}

					}
					// 4 đỉnh xung quanh ko phải là đá
					for (int h = 0; h < 4; h++) {
						int x = i + dx[h];
						int y = j + dy[h];
						if (x >= 0 && x < n && y >= 0 && y < n) {
							if (map[x][y] == 1) {
								check2 = true;
								break;
							}
						}
					}
					if (map[i][j] == 1 && check1 == true && check2 == true) {
						BFS(i, j);
//						System.out.println("visit");
//						resultVisit();
						for (int h = 0; h < g; h++) {
							if (visit[gold[h][0]][gold[h][1]] > max) {
								max = visit[gold[h][0]][gold[h][1]];
							}
						}
						if (min > max) {
							min = max;
						}
						resetVisit();
					}
					// resetVisit();
				}
			}
			System.out.println("Case #" + tc);
			System.out.println(min - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("GoldMining.txt"));
		GoldMining g = new GoldMining();
		g.solution();
	}

}
