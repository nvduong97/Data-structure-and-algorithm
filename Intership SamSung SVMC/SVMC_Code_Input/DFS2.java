package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DFS2 {
	Scanner sc = new Scanner(System.in);
	int t, n;
	int map[][];
	boolean visit[][];

	void DFS(int startX, int startY) {
		visit[startX][startY]=true;
		
	}

	void init() {
		map = new int[n + 1][n + 1];
		visit = new boolean[n+1][n+1];
	}

	void solution() {
		n = sc.nextInt();
		init();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		DFS(1,1);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("DFS2.txt"));
		DFS2 d = new DFS2();
		d.solution();
	}

}
