package practice3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Bai24 { // cay khung cua do thi theo thuat toan DFS
	public static Scanner in = new Scanner(System.in);
	public static boolean cx[] = new boolean[1001];
	public static int a[][] = new int[1001][1001];
	public static int m, n, start;

	public static void main(String[] args) {
		int t = in.nextInt();
		while (t-- > 0) {
			init();
			Dfs(start);
		}
	}

	public static void init() {
		n = in.nextInt();
		m = in.nextInt();
		start = in.nextInt();
		for (int i = 1; i <= n; i++) {
			cx[i] = true;
			Arrays.fill(a[i], 0);
		}
		for (int i = 1; i <= m; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			a[x][y] = 1;
			a[y][x] = 1;
		}
	}

	public static void Dfs(int u) {
		Stack st = new Stack();
		String res[] = new String[n];
		int sc = 0;
		st.push(u);
		cx[u] = false;
		while (!st.isEmpty()) {
			int s = (int) st.peek();
			st.pop();
			for (int t = 1; t <= n; t++) {
				if (cx[t] && a[s][t] == 1) {
					cx[t] = false;
					res[sc] = Integer.toString(s) + " " + Integer.toString(t);
					sc++;
					st.push(s);
					st.push(t);
					break;
				}
			}
		}
		if (sc < n - 1) {
			System.out.println("-1");
		} else {
			for (int i = 0; i < sc; i++) {
				System.out.println(res[i]);
			}
		}
	}
}
