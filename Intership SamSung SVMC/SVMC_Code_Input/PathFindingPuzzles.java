package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * https://alexishuuuocn.wordpress.com/2019/07/18/path-finding-puzzles/
 */
// 1 lượt đi chỉ được đi chỉ được đi thẳng (hoặc ngang, hoặc dọc), ko được rẽ
public class PathFindingPuzzles {
	static int t, n, st, en;
	static int[][] map;
	static int[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] queueX = new int[1000000];
	static int[] queueY = new int[1000000];

	static void BFS(int startX, int startY) {
		// push
		st = en = 0;
		queueX[en] = startX;
		queueY[en] = startY;
		en++;
		visit[startX][startY] = 1;
		while (st != en) {
			// pop
			int x = queueX[st];
			int y = queueY[st];
			st++;
			// đi thẳng không rẽ !
			// dịch 1 phát k bước luôn chứ ko dịch từng bước 1
			for (int i = 0; i < 4; i++) {
				int xNext = x + dx[i] * map[x][y];
				int yNext = y + dy[i] * map[x][y];
				if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < n) {
					if (visit[xNext][yNext] == 0) {
						queueX[en] = xNext;
						queueY[en] = yNext;
						en++;
						visit[xNext][yNext] = 1;
					}
				}

			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("PathFindingPuzzles.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n + 1][n + 1];
			visit = new int[n + 1][n + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// for (int i = 0; i < n; i++) {
			// for (int j = 0; j < n; j++) {
			// System.out.print(map[i][j]+" ");
			// }
			// System.out.println();
			// }
			BFS(0, 0);
			if (visit[n - 1][n - 1] == 1) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

}