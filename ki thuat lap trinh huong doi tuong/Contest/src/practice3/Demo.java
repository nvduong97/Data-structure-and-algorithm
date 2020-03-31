package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Demo {

	public static void DFS(int[][] M, int s, int n, boolean chuaxet[], int pre[]) {
		Stack<Integer> S = new Stack<>();
		S.push(s);
		chuaxet[s] = false;
		int u, v;
		while (!S.empty()) {
			u = S.lastElement();
			S.pop();
			for (v = 1; v <= n; v++) {
				if (M[u][v] == 1 && chuaxet[v] == true) {
					S.push(u);
					S.push(v);
					chuaxet[v] = false;
					pre[v] = u;
					break;
				}
			}
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();
			int u = in.nextInt();
			int v = in.nextInt();

			int M[][] = new int[n + 1][n + 1];
			int pre[] = new int[n + 1];

			for (int i = 0; i < m; i++) {
				int a = in.nextInt();
				int b = in.nextInt();
				M[a][b] = 1;
				M[b][a] = 1;
			}

			boolean chuaxet[] = new boolean[n + 1];
			for (int i = 1; i <= n; i++) {
				chuaxet[i] = true;
				pre[i] = 0;
			}

			pre[u] = u;
			DFS(M, u, n, chuaxet, pre);
			if (pre[v] == 0) {
				System.out.println("-1");
				return;
			} else {
				int count = 1;
				while (pre[v] != u) {
					count++;
					v = pre[v];
				}
				System.out.println(count);
			}
		}
	}
}
