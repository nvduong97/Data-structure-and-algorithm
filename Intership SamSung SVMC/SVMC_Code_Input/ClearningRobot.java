package luyentap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClearningRobot {
	Scanner sc = new Scanner(System.in);
	int t, n, m, L, st, en, ans;
	int map[][], visit[][], adj[][], store[][], hoanVi[];
	int dx[] = { 0, 0, 1, -1 };
	int dy[] = { 1, -1, 0, 0 };
	int queueX[] = new int[1000000];
	int queueY[] = new int[1000000];

	void init() {
		ans = 99999999;
		L = 1;
		map = new int[n][m];
		visit = new int[n][m];
		store = new int[1000][2];
		adj = new int[1000][1000];
		hoanVi = new int[1000];
	}

	void resetVisit() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j] = -1;
			}
		}
	}

	void resultVisit() {
		System.out.println("visit");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
	}

	void BFS(int startX, int startY) {
		st = en = 0;
		queueX[en] = startX;
		queueY[en++] = startY;
		visit[startX][startY] = 0;
		while (st != en) {
			int x = queueX[st];
			int y = queueY[st++];
			for (int i = 0; i < 4; i++) {
				int a = x + dx[i];
				int b = y + dy[i];
				if (a >= 0 && a < n && b >= 0 && b < m) {
					if (visit[a][b] == -1) {
						if (map[a][b] != 2) {
							queueX[en] = a;
							queueY[en++] = b;
							visit[a][b] = visit[x][y] + 1;
						}
					}
				}
			}
		}
	}
	void solve(int index, int last, int count) {
		if(index == L+1) {
			if(count < ans) {
				// bai ong kim chi can them 	if(count + adj[last][L]< ans) { vao
				ans = count;
			}
			return;
		}
		for(int i=0; i<L; i++) {
			if(hoanVi[i] == 0 && adj[last][i] != -1) {
				hoanVi[i] = 1;
				solve(index+1, i, count + adj[last][i]);
				hoanVi[i] = 0;
			}
		}
	}
	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			init();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 3) {
						store[0][0] = i;
						store[0][1] = j;
					}
					if (map[i][j] == 1) {
						store[L][0] = i;
						store[L][1] = j;
						L++;
					}
				}
			}
			System.out.println("L = " + L);
			System.out.println("map");
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("store");
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < 2; j++) {
					System.out.print(store[i][j] + " ");
				}
				System.out.println();
			}
//			System.out.println("STORE");
//			for (int i = 0; i < L; i++) {
//				System.out.println(store[i][0]+" "+store[i][1]);
//			}
			for (int i = 0; i < L; i++) {
				resetVisit();
				BFS(store[i][0], store[i][1]);
				resultVisit();
				for(int j=0; j<L; j++) {
					adj[i][j] = visit[store[j][0]][store[j][1]];
				}
			}
			System.out.println("adj");
			for (int i = 0; i < L; i++) {
				for(int j=0; j<L; j++) {
					System.out.print(adj[i][j]+" ");
				}
				System.out.println();
			}
			solve(1, 0, 0);
			
			System.out.println("Case #"+tc);
			System.out.println(ans);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("ClearningRobot.txt"));
		ClearningRobot c = new ClearningRobot();
		c.solution();
	}

}
