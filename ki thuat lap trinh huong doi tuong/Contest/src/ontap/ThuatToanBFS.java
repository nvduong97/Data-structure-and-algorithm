package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ThuatToanBFS {
	Scanner sc = new Scanner(System.in);
	int t, n, m, u, map[][], visit[], a, b;
	Queue<Integer> queue;

	void BFS(int u) {
		queue.add(u);
		visit[u] = 1;
		while (!queue.isEmpty()) {
			int k = queue.peek();
			queue.remove();
			System.out.print(k + " ");
			for (int v = 1; v <= n; v++) {
				if (map[k][v] != 0 && visit[v] == 0) {
					visit[v] = 1;
					queue.add(v);
				}
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
			queue = new LinkedList<>();
			for (int i = 0; i < m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b] = map[b][a] = 1;
			}
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
			BFS(u);
			queue.clear();
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		ThuatToanBFS thuatToanBFS = new ThuatToanBFS();
		thuatToanBFS.solution();
	}

}
