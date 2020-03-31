package luyentap;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * nếu để xét hướng thì phải cẩn thận chỗ đặt hướng chỗ dx[], dy[]
 */
public class Jogging {
	Scanner sc = new Scanner(System.in);
	int t, n, k, ans;
	int map[][], visit[][], visitHuong[];
	int dx[] = { 1, -1, 0, 0 };
	int dy[] = { 0, 0, 1, -1 };
	int xEnd = 0, yEnd = 0;
	int huong;

	void init() {
		huong = -1;
		ans = 0;
		map = new int[n][n];
		visit = new int[n][n];
		visitHuong = new int[4];
	}
	// false ở đây là do mình ko thay đổi biến hướng or ko truyền biến hướng vào backTrack
	void backTrack(int startX, int startY, int count, int huong, int total) {
		if (startX == xEnd && startY == yEnd && total <=k) {
			if (count > ans) {
				ans = count;
			}
			// không return được vì có nhiều điểm cần xét
			 //return;
		}
		if(total > k) {
			if (count > ans) {
				ans = count;
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int x = startX + dx[i];
			int y = startY + dy[i];
			if (x >= 0 && x < n && y >= 0 && y < n && visit[x][y] == 0) {
				int d = map[x][y] - map[startX][startY];
				if (huong == i ) {
					// sai chỗ này vừa xong, phải là năng lương <=k chứ ko phải tổng
					if (d >= 0 && total + d * d*2 + 1 <= k) {
						visit[x][y] = 1;
						backTrack(x, y, count + 1, i, total +d * d*2 + 1);
						visit[x][y] = 0;
					}
					if (d < 0 && total + d * d + 1 <= k) {
						visit[x][y] = 1;
						backTrack(x, y, count + 1, i, total + d * d + 1);
						visit[x][y] = 0;
					}
				}
				// đi thi mà nhầm thế này là toi sai ở chỗ để huong + 1 != 0 && huong - 1 != 0 mà phải để ở dưới là bằng i
				// chỗ đó là tránh để xét phải trường hợp đi theo hướng đó rồi đi lại, do xét chiều đi của hình chữ nhật ở dx, dy
				if (huong != i && visitHuong[i] == 0 && huong + 1 != i && huong - 1 != i) {
					visitHuong[i] = 1;
					if (d >= 0 && total + d * d*2 + 1 <= k) {
						visit[x][y] = 1;
						backTrack(x, y, count + 1, i, total +d * d*2 + 1);
						visit[x][y] = 0;
					}
					if (d < 0 && total + d * d + 1 <= k) {
						visit[x][y] = 1;
						backTrack(x, y, count + 1, i, total + d * d + 1);
						visit[x][y] = 0;
					}
					visitHuong[i] = 0;
				}
			}

		}
	}

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			init();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					xEnd = i;
					yEnd = j;
					backTrack(i, j, 0, huong, 0);
				}
			}
			System.out.println("Case #" + tc + " " + ans);
		}
	}

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("Jogging.txt"));
		Jogging so = new Jogging();
		so.solution();
	}
}