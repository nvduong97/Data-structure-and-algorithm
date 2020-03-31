package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Bai17 { // thuat toan BFS
	Scanner sc = new Scanner(System.in);
	int t, n, a, b, m, u;
	int map[][];
	int visit[];
	Queue<Integer> queue;

	void BFS(int s) {
		queue.add(s);
		visit[s] = 1;
		while (!queue.isEmpty()) {
			int k = queue.peek();
			queue.remove();
			System.out.print(k + " ");
			for (int v = 1; v <= n; v++) {
				if (visit[v] == 0 && map[k][v] == 1) {
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
			queue = new LinkedList<Integer>();
			for (int i = 1; i <= m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b] = map[b][a] = 1;
			}
			BFS(u);
			queue.clear();
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai17 bai1 = new Bai17();
		bai1.solution();
	}
}
