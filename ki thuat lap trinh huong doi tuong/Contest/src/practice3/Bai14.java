package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Mình cũng éo hiểu sao bài này viết DFS truyền vào 1 tham số thì TLE, còn truyền vào 4 tham số như tham khảo thì AC
 */
public class Bai14 { // tim duong di trong do thi vo huong
	Scanner sc = new Scanner(System.in);
	int t, n, m, a, b, q, k;
	int map[][];
	int visit[];

	void DFS(int map[][], int n, int start, int visit[]) {
		visit[start] = 1;
		for (int v = 1; v <= n; v++) {
			if (map[start][v] != 0 && visit[v] == 0) {
				DFS(map, n, v, visit);
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
			q = sc.nextInt();
			for (int i = 1; i <= q; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				visit = new int[n + 1];
				// DFS(start);
				DFS(map, n, start, visit);
				if (visit[end] == 1) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai14 bai1 = new Bai14();
		bai1.solution();
	}
}
