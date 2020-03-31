package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MountainWalkingBFS {
	Scanner sc = new Scanner(System.in);
	int t, n, hmin, hmax, tail, head;
	int arr[][];
	int visit[][];
	int Qx[];
	int Qy[];
	int dx[] = { 1, -1, 0, 0 };
	int dy[] = { 0, 0, 1, -1 };

	void init() {
		Qx = new int[1000000];
		Qy = new int[1000000];
		hmax = 0;
		hmin = 99999;
		arr = new int[n + 1][n + 1];
		visit = new int[n + 1][n + 1];
	}

	void reset() {
		visit = new int[n + 1][n + 1];
	}

	boolean VetCan(int x) {
		for (int i = hmin; i <= hmax - x; i++) {
			reset();
			if (BFS(i, i + x, 0, 0) == 1) {
				return true;
			}
		}
		return false;
	}

	// Chứng tỏ vừa xong mình viết hàm BFS bị sai chỗ nào mà ko nhìn ra được. Nếu đi
	// thi mà rơi vào tình trạng này thì cách 1 là soi lại code, cách 2 là xóa đi
	// code lại hàm BFS đó
	int BFS(int start, int end, int x, int y) {
//		if (arr[x][y] < start || arr[x][y] > end) {
//			return 0;
//		} else {
//			head = tail = 0;
//			Qx[tail] = x;
//			Qy[tail] = y;
//			tail++;
//			visit[x][y] = 1;
//			while (head != tail) {
//				int xx = Qx[head];
//				int yy = Qy[head];
//				head++;
//				for (int i = 0; i < 4; i++) {
//					int xNext = xx + dx[i];
//					int yNext = yy + dy[i];
//					if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < n && visit[xNext][yNext] == 0) {
//						if (arr[xNext][yNext] >= start && arr[xNext][yNext] <= end) {
//							if (xNext == (n - 1) && yNext == (n - 1)) {
//								return 1;
//							} else {
//								visit[xNext][yNext] = 1;
//								Qx[tail] = xNext;
//								Qy[tail] = yNext;
//								tail++;
//							}
//						}
//					}
//				}
//			}
//		}
//		return 0;
		if (arr[x][y] < start || arr[x][y] > end) {
			return 0;
		} else {
			tail = head = 0;
			Qx[tail] = x;
			Qy[tail] = y;
			tail++;
			visit[x][y] = 1;
			while (tail != head) {
				int xx = Qx[head];
				int yy = Qy[head];
				head++;
				for (int i = 0; i < 4; i++) {
					int xNext = xx + dx[i];
					int yNext = yy + dy[i];
					if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < n) {
						if (visit[xNext][yNext] == 0) {
							if (arr[xNext][yNext] >= start && arr[xNext][yNext] <= end) {
								if (xNext == n - 1 && yNext == n - 1) {
									return 1;
								} else {
									Qx[tail] = xNext;
									Qy[tail] = yNext;
									tail++;
									visit[xNext][yNext] = 1;
								}
							}
						}
					}
				}
			}
		}
		return 0;
	}

	void solution() {
		n = sc.nextInt();
		init();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] > hmax) {
					hmax = arr[i][j];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] < hmin) {
					hmin = arr[i][j];
				}
			}
		}
		// chặt nhị phân để tìm ra left & right
		int left = 0;
		int right = hmax - hmin;
		int mid = (left + right) / 2;
		while (left != mid && right != mid) {
			if (VetCan(mid)) {
				right = mid;
				mid = (left + right) / 2;
			} else {
				left = mid;
				mid = (left + right) / 2;
			}
		}
		for (int i = left; i <= right; i++) {
			if (VetCan(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("MountainWalking.txt"));
		MountainWalkingBFS m = new MountainWalkingBFS();
		m.solution();
	}

}
