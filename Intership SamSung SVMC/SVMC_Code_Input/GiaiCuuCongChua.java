package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * công từ sẽ bắt đầu từ cửa mê cung tại vị trí (0,0)
 * sẽ đi tìm công chúa trong ma trận nxn, tại ô có giá trị là 2 thì sẽ có công chúa
 * (n-1,n-1) sẽ là cửa thoát ra
 * 0 - tường gạch: ko đi xuyên qua được
 * 1 - đường đi
 * 2 - vị trí công chúa bị giam giữ
 * Tìm số bước công tử đi để giải cứu được công chúa 
 * 
 * 1 ô trong ma trận chỉ được đi 1 lần duy nhất, ko đi lại
 * 
 * Do mình ko down nhưng ghichuonline chỉ giới hạn nên chỉ có thể chạy được 7/10 testcase
 */
public class GiaiCuuCongChua {
	static int t, n, st, en;
	static int[][] map;
	static int[][] visit;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[] queueX = new int[1000000];
	static int[] queueY = new int[1000000];

	static void BFS(int startX, int startY) {
		// pusht
		st = en = 0;
		queueX[en] = startX;
		queueY[en] = startY;
		en++;
		visit[startX][startY] = 1;
		while (st != en) {
			// pop or font
			int x = queueX[st];
			int y = queueY[st];
			st++;
			for (int i = 0; i < 4; i++) {
				int xNext = x + dx[i];
				int yNext = y + dy[i];
				if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < n) {
					if (map[xNext][yNext] == 1 || map[xNext][yNext] == 2) {
						if (visit[xNext][yNext] == 0) {
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

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("GiaiCuuCongChua.txt"));
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
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 2) {
						BFS(i, j);
						break;
					}
				}
			}
			if (visit[0][0] != 0 && visit[n - 1][n - 1] != 0) {
				int sum = visit[n - 1][n - 1] + visit[0][0] - 2;
				System.out.println(sum);
			} else {
				System.out.println(-1);
			}
			// hoặc xét ngược lại cũng được
//			if (visit[0][0] == 0 || visit[n - 1][n - 1] == 0) { // nếu ko tới được thì in ra -1
//				System.out.println("#" + tc + " -1");
//			} else {
//				int sum = visit[0][0] + visit[n - 1][n - 1] - 2;
//				System.out.println("#" + tc + " " + sum);
//			}
		}

	}

}
