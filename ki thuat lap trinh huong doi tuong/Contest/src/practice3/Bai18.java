package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai18 { // thuat toan DFS
	Scanner sc = new Scanner(System.in);
	int t, n, a, b, m, u;
	int map[][];
	int visit[];

	void DFS(int index) {
		System.out.print(index + " ");
		visit[index] = 1;
		for (int v = 1; v <= n; v++) {
			if (map[index][v] != 0 && visit[v] == 0) {
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
		Bai18 bai1 = new Bai18();
		bai1.solution();
	}
}
