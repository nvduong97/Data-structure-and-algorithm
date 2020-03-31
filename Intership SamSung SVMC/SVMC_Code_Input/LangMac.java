package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * https://alexishuuuocn.wordpress.com/2019/07/18/lang-mac/
 */
public class LangMac {
	static int t, n, soVung, soLangCoLap, soConDuong;
	static int[][] map;
	static int[] visit;
	static int[] visitCau;
	static int[] queueCau = new int[1000000];
	static int vaoCau, raCau;

	static void DFS(int index) {
		visit[index] = 1;
		for (int i = 1; i <= n; i++) {
			if (map[index][i] == 1 && visit[i] == 0) {
				DFS(i);
			}
		}
	}
	/*
	 * tìm cầu: xét 1 đỉnh, xét các đỉnh xung quanh đang nối với đỉnh đó, xóa đường
	 * đi đỉnh thuộc vùng đó nếu tăng vùng lên thì tăng CẦU lên còn xóa đi mà ko
	 * tăng được CẦU lên thì dẹp.
	 */

	static void check(int x, int y) {
		visitCau = new int[n + 1];
		vaoCau = raCau = 0;
		visitCau[x] = 1;
		int k = 0;
		for (int i = 1; i <= n; i++) {
			if (i != y && map[x][i] == 1) {
				k++;
				visitCau[i] = 1;
				queueCau[vaoCau++] = i;
			}
		}
		if (k == 0) {
			soConDuong++;
			return;
		}
		while (vaoCau != raCau) {
			int tx = queueCau[raCau++];
			for (int i = 1; i <= n; i++) {
				if (map[tx][i] == 1) {
					if (visitCau[i] == 0) {
						if (i == y) {
							return;
						}
						visitCau[i] = 1;
						queueCau[vaoCau++] = i;
					}
				}
			}
		}
		soConDuong++;
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("LangMac.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n + 1][n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			visit = new int[n + 1];
			soVung = 0;
			soLangCoLap = 0;
			soConDuong = 0;
			DFS(1);
			soVung++;
			for (int i = 1; i <= n; i++) {
				if (visit[i] == 0) {
					DFS(i);
					soVung++;
				}
			}

			// neu co 1 hang co gia tri 0 tat thi la co lap: ko co duong di toi diem nao
			for (int i = 1; i <= n; i++) {
				int count = 0;
				for (int j = 1; j <= n; j++) {
					if (map[i][j] == 0) {
						count++;
					}
				}
				if (count == n) {
					soLangCoLap++;
				}
			}
			// tim so con duong la cau noi giua 2 vung
			// check xem nếu xóa 1 đỉnh nó có tạo ra vùng mới không, nếu có thì tăng CẦU lên
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] == 1) {
						check(i, j);
					}
				}
			}
			System.out.println("Case #" + tc + " " + soVung + " " + soLangCoLap + " " + soConDuong / 2);

		}
	}

}
