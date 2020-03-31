package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//chứng tỏ cái hàm BFS này của mình bị vấn đề gì đó
//chỗ này phải là map[k][v] mình lại viết nhầm thành map[u][v]
public class Bai19 { // thanh phan lien thong BFS
	Scanner sc = new Scanner(System.in);
	int t, n, m, a, b;
	int map[][];
	boolean thanhPhanLienThong[], visit[];
	Queue<Integer> queue;

	void BFS(int u) {
		queue.add(u);
		visit[u] = true;
		while (!queue.isEmpty()) {
			int k = queue.peek();
			queue.remove();
			thanhPhanLienThong[k] = true;
			System.out.print(k + " ");
			for (int v = 1; v <= n; v++) {
				if (map[k][v] == 1 && visit[v] == false) {
					visit[v] = true;
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
			map = new int[n + 1][n + 1];
			for (int i = 1; i <= m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b] = map[b][a] = 1;
			}
			thanhPhanLienThong = new boolean[n + 1];
			visit = new boolean[n + 1];
			queue = new LinkedList<>();
			for (int j = 1; j <= n; j++) {
				if (thanhPhanLienThong[j] == false) {
					BFS(j);
					System.out.println();
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai19 bai19 = new Bai19();
		bai19.solution();
	}
}
