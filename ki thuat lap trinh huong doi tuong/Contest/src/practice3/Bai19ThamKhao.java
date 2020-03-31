package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai19ThamKhao {

	static Queue<Integer> queue;
	static boolean visit[];
	static boolean thanhPhanLienThong[];
	static int n;
	static int map[][];

	public static void BFS(int i) {
		queue.add(i);
		visit[i] = true;
		while (!queue.isEmpty()) {
			int u = queue.peek();
			queue.remove();
			System.out.print(u + " ");
			thanhPhanLienThong[u] = true;
			for (int v = 1; v <= n; v++) {
				if (visit[v] == false && map[u][v] == 1) {
					visit[v] = true;
					queue.add(v);
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt();
			int m = in.nextInt();
			map = new int[n + 1][n + 1];
			for (int i = 0; i < m; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				map[a][b] = 1;
				map[b][a] = 1;
			}
			thanhPhanLienThong = new boolean[n + 1];
			visit = new boolean[n + 1];
			queue = new LinkedList<Integer>();
			for (int j = 1; j <= n; j++) {
				if (thanhPhanLienThong[j] == false) {
					BFS(j);
					System.out.println("");
				}
			}
		}
	}
}
