package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClearningRobot2 {
	Scanner sc = new Scanner(System.in);
	int t, n, m, st, en, L, ans;
	int map[][], visit[][], vertex[][], adj[][], hoanVi[];
	int queueX[] = new int[1000000];
	int queueY[] = new int[1000000];
	int dx[] = { 1, -1, 0, 0 };
	int dy[] = { 0, 0, 1, -1 };

	void init() {
		ans = 99999999;
		L = 1;
		st = en = 0;
		map = new int[n + 1][m + 1];
		visit = new int[n + 1][m + 1];
		vertex = new int[n * m][2];
		adj = new int[n * m][n * m];
		hoanVi = new int[n * m];
	}

	void resetVisit() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visit[i][j] = -1;
			}
		}
	}
	// chứng tỏ cái hàm solve của mình bị tắt điện
	void solve(int index, int last, int sum) {
		if(index == L+1) {
			if(sum < ans) {
				ans = sum;
			}
			return;
		}
		for(int i=0; i<L; i++) {
			if(hoanVi[i]==0 && adj[last][i]!=-1) {
				hoanVi[i]=1;
				solve(index+1, i, sum  + adj[last][i]);
				hoanVi[i]=0;
			}
		}
	}

	void BFS(int startX, int startY) {
		queueX[en] = startX;
		queueY[en] = startY;
		en++;
		visit[startX][startY] = 0;
		while(st != en) {
			int x = queueX[st];
			int y = queueY[st];
			st++;
			for(int i=0; i<4; i++) {
				int xNext = x + dx[i];
				int yNext = y + dy[i];
				if(xNext>=0 && xNext<n && yNext>=0 && yNext<m) {
					if(visit[xNext][yNext]==-1) {
						if(map[xNext][yNext]!=2) {
							queueX[en] = xNext;
							queueY[en] = yNext;
							en++;
							visit[xNext][yNext] = visit[x][y] + 1;
						}
					}
				}
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
				}
			}
//			System.out.println("map");
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < m; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[i][j] == 3) {
						vertex[0][0] = i;
						vertex[0][1] = j;
					}
					if (map[i][j] == 1) {
						vertex[L][0] = i;
						vertex[L][1] = j;
						L++;
					}
				}
			}
//			System.out.println("vertex");
//			for (int i = 0; i < L; i++) {
//				for (int j = 0; j < 2; j++) {
//					System.out.print(vertex[i][j]+" ");
//				}
//				System.out.println();
//			}
			for (int i = 0; i < L; i++) {
				resetVisit();
				BFS(vertex[i][0], vertex[i][1]);
//				System.out.println("visit");
//				for (int h = 0; h < n; h++) {
//					for (int k = 0; k < m; k++) {
//						System.out.print(visit[h][k]+" ");
//					}
//					System.out.println();
//				}
				for (int j = 0; j < L; j++) {
					adj[i][j] = visit[vertex[j][0]][vertex[j][1]];
				}
			}
//			System.out.println("adj");
//			for (int i = 0; i < L; i++) {
//				for (int j = 0; j < L; j++) {
//					System.out.print(adj[i][j]+" ");
//				}
//				System.out.println();
//			}
			solve(1, 0, 0);
			if(ans == 99999999) {
				ans = -1;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("ClearningRobot.txt"));
		ClearningRobot2 c = new ClearningRobot2();
		c.solution();
	}

}
