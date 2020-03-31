package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Đi từ vị trí (0,0) tới vị trí (n-1,n-1) trong ma trận 2 chiều được hay không
 * biết rằng với giá trị đang đứng thì ta nhảy đi đúng với giá trị trong ô đó
 * biết rằng chỉ có thể nhảy lên, xuống, trái, phải (4 hướng)
 * 
 * giải thuật: ko khác BFS là bao, chỉ biến đổi xíu thôi 
 */
public class CauDo {
	Scanner sc = new Scanner(System.in);
	int t, n, st, en;
	int map[][];
	boolean visit[][];
	int dx[] = { 1, -1, 0, 0 };
	int dy[] = { 0, 0, 1, -1 };
	int queueX[];
	int queueY[];

	void init() {
		st = en = 0;
		queueX = new int[1000000];
		queueY = new int[1000000];
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1][n + 1];
	}

	void BFS(int startX, int startY) {
		st = en = 0;
		queueX[en] = startX;
		queueY[en] = startY;
		en++;
		visit[startX][startY] = true;
		while (st != en) {
			int x = queueX[st];
			int y = queueY[st];
			st++;
			for (int i = 0; i < 4; i++) {
				int xNext = x + dx[i] * map[x][y];
				int yNext = y + dy[i] * map[x][y];
				if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < n) {
					if (visit[xNext][yNext] == false) {
						queueX[en] = xNext;
						queueY[en] = yNext;
						en++;
						visit[xNext][yNext] = true;
					}
				}
			}
		}
	}

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			BFS(0, 0);
			if (visit[n - 1][n - 1] == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("CauDo.txt"));
		CauDo k = new CauDo();
		k.solution();
	}

}
