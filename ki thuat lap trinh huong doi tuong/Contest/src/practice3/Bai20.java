package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai20 { // thanh phan lien thong DFS
	Scanner sc = new Scanner(System.in);
	int t, n, m, a, b;
	int map[][];
	boolean thanhPhanLienThong[], visit[];

	void DFS(int u) {
		visit[u] = true;
		thanhPhanLienThong[u] = true;
		System.out.print(u + " ");
		for (int v = 1; v <= n; v++) {
			if (map[u][v] == 1 && visit[v] == false) {
				DFS(v);
			}
		}
	}

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n + 1][n + 1];
			for (int i = 1; i <= m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b] = map[b][a] = 1;
			}
			thanhPhanLienThong = new boolean[n + 1];
			visit = new boolean[n + 1];
			for (int j = 1; j <= n; j++) {
				if (thanhPhanLienThong[j] == false) {
					DFS(j);
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai20 bai19 = new Bai20();
		bai19.solution();
	}
}
