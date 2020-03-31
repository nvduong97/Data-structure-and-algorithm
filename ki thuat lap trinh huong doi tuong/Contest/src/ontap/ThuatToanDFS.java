package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThuatToanDFS {
	Scanner sc = new Scanner(System.in);
	int t, n, m, u, a, b;
	int map[][], visit[];

	void DFS(int u) {
		System.out.print(u + " ");
		visit[u] = 1;
		for (int v = 1; v <= n; v++) {
			if (map[u][v] == 1 && visit[v] == 0) {
				DFS(v);
			}
		}
	}

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			u = sc.nextInt();
			map = new int[n + 1][n + 1];
			visit = new int[n + 1];
			for (int i = 1; i <= m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b] = map[b][a] = 1;
			}
			DFS(u);
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		ThuatToanDFS thuatToanDFS = new ThuatToanDFS();
		thuatToanDFS.solution();
	}

}
