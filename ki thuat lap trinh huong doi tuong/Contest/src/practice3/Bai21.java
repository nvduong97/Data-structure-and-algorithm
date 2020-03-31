package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai21 { // duong di BFS
	Scanner sc = new Scanner(System.in);
	int t, n, m, start, end, a, b;
	int map[][];
	boolean visit[];
	int duongDi[];
	Queue<Integer> queue;

	void BFS(int Start, int End) {
		queue.add(Start);
		visit[Start] = true;
		while (!queue.isEmpty()) {
			int k = queue.peek();
			queue.remove();
			for (int v = 1; v <= n; v++) {
				if (map[k][v] == 1 && visit[v] == false) {
					visit[v] = true;
					queue.add(v);
					duongDi[v] = k;
				}
			}
		}
	}

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			start = sc.nextInt();
			end = sc.nextInt();
			map = new int[n + 1][n + 1];
			visit = new boolean[n + 1];
			duongDi = new int[n + 1];
			queue = new LinkedList<Integer>();
			for (int i = 1; i <= m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b] = map[b][a] = 1;
			}
			duongDi[start] = start;
			BFS(start, end);
			if (visit[end] == false) {
				System.out.println(-1);
			} else {
				int count = 1;
				while (duongDi[end] != start) {
					count++;
					end = duongDi[end];
				}
				System.out.println(count);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai21 bai21 = new Bai21();
		bai21.solution();
	}
}
