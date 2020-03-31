package luyentap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* 
 * chẵn đi chéo lên trên
 * lẽ đi chéo xuống dưới
 * backTrack 1 đường đi 6 đỉnh xung quanh, tìm ra 4 đỉnh có tổng lớn nhất kề nhau
 * backTrack2 đi các đỉnh liền kề nhau, 4 đỉnh liên tiếp có tổng lớn nhất
 */
public class BaseStation {
	Scanner sc = new Scanner(System.in);
	int t, n, m;
	long max;
	int map[][], visit[][];
	int dxChan[] = { -1, -1, -1, 0, 0, 1 };
	int dyChan[] = { -1, 0, 1, -1, 1, 0 };
	int dxLe[] = { 1, 1, 1, 0, 0, -1 };
	int dyLe[] = { -1, 0, 1, -1, 1, 0 };

	void init() {
		max = 0;
		map = new int[n][m];
		visit = new int[n][m];
	}

	void backTrack(int x, int y, int num, int sum) {
		if (num == 3) {
			if (sum > max) {
				max = sum;
			}
			return;
		} else {
			if (y % 2 == 0) {
				for (int i = 0; i < 6; i++) {
					int a = x + dxChan[i];
					int b = y + dyChan[i];
					if (a >= 0 && a < n && b >= 0 && b < m) {
						if (visit[a][b] == 0) {
							visit[a][b] = 1;
							backTrack(a, b, num + 1, sum + map[a][b]);
							visit[a][b] = 0;
						}
					}
				}
			} else {
				for (int i = 0; i < 6; i++) {
					int a = x + dxLe[i];
					int b = y + dyLe[i];
					if (a >= 0 && a < n && b >= 0 && b < m) {
						if (visit[a][b] == 0) {
							visit[a][b] = 1;
							backTrack(a, b, num + 1, sum + map[a][b]);
							visit[a][b] = 0;
						}
					}
				}
			}
		}
	}

	void backTrack2(int x, int y, int num, int sum) {
		if (num == 3) {
			if (sum > max) {
				max = sum;
			}
			return;
		} else {
			if (y % 2 == 0) {
				for (int i = 0; i < 6; i++) {
					int a = x + dxChan[i];
					int b = y + dyChan[i];
					if (a >= 0 && a < n && b >= 0 && b < m) {
						if (visit[a][b] == 0) {
							visit[a][b] = 1;
							backTrack2(x, y, num + 1, sum + map[a][b]);
							visit[a][b] = 0;
						}
					}
				}
			} else {
				for (int i = 0; i < 6; i++) {
					int a = x + dxLe[i];
					int b = y + dyLe[i];
					if (a >= 0 && a < n && b >= 0 && b < m) {
						if (visit[a][b] == 0) {
							visit[a][b] = 1;
							backTrack2(x, y, num + 1, sum + map[a][b]);
							visit[a][b] = 0;
						}
					}
				}
			}
		}
	}

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			m = sc.nextInt();
			n = sc.nextInt();
			init();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					visit[i][j] = 1;
					backTrack(i, j, 0, map[i][j]);
					backTrack2(i, j, 0, map[i][j]);
					visit[i][j] = 0;
				}
			}
			System.out.println("Case #" + tc);
			System.out.println(max * max);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BaseStation.txt"));
		BaseStation b = new BaseStation();
		b.solution();
	}

}
