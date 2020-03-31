package luyentap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GoldMining2 {
	Scanner sc = new Scanner(System.in);
	int t, n, g, ans, st, en;
	int map[][], gold[][], visit[][];
	int dx[] = { 0, 0, 1, -1 };
	int dy[] = { 1, -1, 0, 0 };
	int queueX[] = new int[1000000];
	int queueY[] = new int[1000000];

	void init() {
		map = new int[n + 1][n + 1];
		visit = new int[n + 1][n + 1];
		gold = new int[g + 1][2];
	}

	void resetVisit() {
		visit = new int[n + 1][n + 1];
	}

	void resultVisit() {
		System.out.println("visit");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
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
				if (a >= 1 && a <= n && b >= 1 && b <= n) {
					if (visit[a][b] == 0) {
						if (map[a][b] != 0) {
							queueX[en] = a;
							queueY[en++] = b;
							visit[a][b] = visit[x][y] + 1;
						}
					}
				}
			}
		}
	}

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			g = sc.nextInt();
			init();
			for (int i = 1; i <= g; i++) {
				gold[i][0] = sc.nextInt();
				gold[i][1] = sc.nextInt();
				// System.out.println(gold[i][0] + " " + gold[i][1]);
			}
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
//   System.out.println("map");
//   for (int i = 1; i <= n; i++) {
//    for (int j = 1; j <= n; j++) {
//     System.out.print(map[i][j] + " ");
//    }
//    System.out.println();
//   }
//   System.out.println("=====================");
			// ==========================
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					for (int u = 1; u <= g; u++) {
						if (i == gold[u][0] && j == gold[u][1]) {
							map[i][j] = 2;
						}
					}
				}
			}
			// ==========================
//   System.out.println("map");
//   for (int i = 1; i <= n; i++) {
//    for (int j = 1; j <= n; j++) {
//     System.out.print(map[i][j] + " ");
//    }
//    System.out.println();
//   }
			// ==========================
			// vị trí đặt trại ko phải là mỏ vàng, là đường đi (1) và 4 phía xung quanh tất
			// cả ko phải là đá
			// Mà kể cả xét trường hợp như vậy cũng chả sao vì ở dưới ta xét max = 0 rồi if (ABC > max) rồi
			// nên trường hợp đặt trại xung quanh 4 bên là đá sẽ bị loại
			int min = 99999999;
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					int max = 0;
					if (map[i][j] == 1) {
						BFS(i, j);
						// resultVisit();
						// xét testcase1 có 2 mỏ vàng, ta xét chi phí tới mỏ vàng gần nhất
						for (int u = 1; u <= g; u++) {
							// Lấy chi phí mỏ vàng thấp nhất khi BFS tại 1 đỉnh
							if (visit[gold[u][0]][gold[u][1]] > max) {
								max = visit[gold[u][0]][gold[u][1]];
								// System.out.println("max = "+max);
							}
						}
						// có k vị trí đặt mỏ vàng thì ta xét k trường hợp đó và lấy chi phí nhỏ nhất
						if (min > max) {
							min = max;
							// System.out.println("min = "+min);
						}
						resetVisit();
					}

				}
			}
			System.out.println("Case #" + tc);
			System.out.println(min - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("GoldMining.txt"));
		GoldMining2 g = new GoldMining2();
		g.solution();
	}

}
