package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * http://www.hoangvancong.com/2016/11/05/hugo/
 * Hugo đi sao cho nhặt được nhiều kim cương nhất
 * ko đi tới được đích thì in ra -1
 * Còn thiếu đề vs thí dụ, mai copy tiếp
 */
public class Hugo {
	Scanner sc = new Scanner(System.in);
	int t, n, m, SR, SC, k, st, en, x, y, nextTime, ans;
	int fire[][], map[][], diamond[][], visit[][];
	int queueX[] = new int[1000000];
	int queueY[] = new int[1000000];
	int dx[] = { 1, -1, 0, 0 };
	int dy[] = { 0, 0, 1, -1 };
	// khởi tạo thế này chỉ AC 34/100 thôi, phải khởi tạo lại vs sức chứa lớn hơn như 1000x1000, hay 100x100
	// và khởi tạo mà lớn thì cho ra ngoài main, tránh mỗi test case lại khởi tạo lại vì như thế dễ bị time out
	void init() {
		ans = -1;
		st = en = 0;
		fire = new int[n + 1][m + 1];
		map = new int[n + 1][m + 1];
		diamond = new int[n + 1][m + 1];
		visit = new int[n + 1][m + 1];
	}

	// BFS lửa lan
	void BFS() {
		while (st != en) {
			int xx = queueX[st];
			int yy = queueY[st];
			st++;
			for (int i = 0; i < 4; i++) {
				int xNext = xx + dx[i];
				int yNext = yy + dy[i];
				if (xNext >= 1 && xNext <= n && yNext >= 1 && yNext <= m) {
					if (fire[xNext][yNext] == 1000) {
						if (map[xNext][yNext] <= 1) {
							fire[xNext][yNext] = fire[xx][yy] + 1;
							queueX[en] = xNext;
							queueY[en] = yNext;
							en++;
						}
					}
				}
			}
		}

	}

	// DFS-backTracking Hugo đi
	void solve(int xx, int yy, int time, int score) {
		visit[xx][yy] = 1;
		if (map[xx][yy] == 1 || map[xx][yy] == 4) {
			if (score > ans) {
				ans = score;
			}
			// chỗ này ko được reset vì có nhiều lối thoát, reset sẽ chỉ chạy tới 1 exit rồi
			// thoát luôn
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

					// nếu thời gian Hugo chạy tới nhỏ hơn thời gian lửa lan thì Duyệt tiếp vị trí
					// tiếp theo
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
			// kích thước bản đồ
			n = sc.nextInt();
			m = sc.nextInt();
			SR = sc.nextInt();
			SC = sc.nextInt();
			init();
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					fire[i][j] = 1000;
				}
			}
			// vị trí Hugo đứng trong bản đồ

			// k ngọn lửa
			// chú ý chỗ khởi tạo
			k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				// en = 0 : vừa xong bị false chỗ này, lý do là mỗi lần chạy xong lại reset en
				// về 0
				x = sc.nextInt();
				y = sc.nextInt();
				fire[x][y] = 0;
				queueX[en] = x;
				queueY[en] = y;
				en++;
			}
			// k hồ nước
			k = sc.nextInt();
			for (int i = 0; i < k; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				map[x][y] = 2;
			}
			// k lối thoát
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
			// kim cương
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= m; j++) {
					diamond[i][j] = sc.nextInt();
				}
			}
			// Hugo đi tại vị trí trên bản đồ, vs time=0 và kim cương ở ô xuất phát lấy luôn
			BFS();
			//solve(SR, SC, 0, diamond[SC][SC]); lại hay sai mấy cái lỗi chính tả này
			solve(SR, SC, 0, diamond[SR][SC]);
			System.out.println("Case #" + tc);
			System.out.println(ans);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Hugo.txt"));
		Hugo h = new Hugo();
		h.solution();
	}

}
