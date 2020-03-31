package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Dùng chặt nhị phân.

Hàm kiểm tra ta dùng BFS.
Bài toán đưa về bài toán con: với độ chênh lệch nhỏ nhất là k, ta có đường đi từ ô (1,1) tới ô (n,n) hay không.

Chặt nhị phân độ chênh lệch, với mỗi độ chênh lệch mid trong lúc chặt , kiểm tra xem có tồn tại đường đi từ (1,1) đến ô (n,n) mà chênh lệch không quá mid hay không. Dùng BFS loang tìm đường đi từ (1,1) đến (n,n). Tuy nhiên nếu chỉ đơn thuần là xét các đường đi với việc lưu max, min thì bài toán sẽ không hề đơn giản, vì mỗi ô lúc đó sinh ra thêm 110*110 đỉnh khác, tương ứng với max, min tại mỗi ô. Do đó ta tạo hai biến L, R lưu khoảng giá trị mặc định của các ô, vì chênh lệch cao nhất và thấp nhất là trong khoảng mid nên ta chỉ cần tạo khoảng (L,R) mà R-L = mid, khi đó chỉ xét các ô trong khoảng này thì đảm bảo tính chất bài toán

Do đó ĐPT : O(log(N) * N * N^2).

Chặt nhị phân khoảng cách và duyệt BFS xem có đi được tới đích không ?
nếu đi được thì tiếp tục chặt nhị phân, còn ko chặt được nữa hay ko BFS được thì đó chính là khoảng cách nhỏ nhất
khoảng cách [a - b] này để xét khoảng mà mãi mình mới hiểu là sao ?
chính là khoảng cách để thỏa mãn duyệt đường đi tới đích mà thỏa mãn độ cao đang xét

	Bài này làm cùng 1 code chạy DFS thì time limited 
	cũng code đấy chạy C++ thì AC luôn, chắc bên Java phải set up lại thời gian
 */
public class MountainWalking {
	Scanner sc = new Scanner(System.in);
	int n;
	int map[][];
	boolean visit[][];
	int dx[] = { 1, -1, 0, 0 };
	int dy[] = { 0, 0, 1, -1 };

	void DFS(int i, int j, int start, int end) {
//		if (i < 0 || i >= n || j < 0 || j >= n)
//			return;
//		if (visit[i][j])
//			return;
//		if (map[i][j] < start || map[i][j] > end)
//			return;
//		visit[i][j] = true;
//		for (int dx = -1; dx <= 1; dx++) {
//			for (int dy = -1; dy <= 1; dy++) {
//				if ((dx == 0) ^ (dy == 0)) {
//					DFS(i + dx, j + dy, start, end);
//				}
//			}
//		}
		visit[i][j] = true;
		for (int k = 0; k < 4; k++) {
			int xNext = i + dx[k];
			int yNext = j + dy[k];
			if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < n) {
				if (visit[xNext][yNext] == false) {
					if (map[xNext][yNext] >= start && map[xNext][yNext] <= end) {
						DFS(xNext, yNext, start, end);
					}
				}
			}
		}
	}

	void init() {
		map = new int[111][111];
		visit = new boolean[111][111];
	}

	/*
	 * Chắc lúc trước mình viết sai chỗ nào trong hàm solution nên kết quả bằng 0
	 * Cũng ko nhớ lắm, vì copy thẳng từ bên C++ rồi chỉnh sửa chút cout, cin bằng
	 * scanner vs sysout !
	 */
	void solution() {
		int t;
		// t = sc.nextInt();
		// for (int tc = 1; tc <= t; tc++) {
		n = sc.nextInt();
		init();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int left = 0, right = 111;
		int ans = 0;
		while (left < right) {
			int mid = (left + right) / 2;
			boolean ok = false;
			for (int st = 0; st <= 111; ++st) {
				// mỗi lần DFS xong phải reset visit để còn đi lại
				visit = new boolean[111][111];
				DFS(0, 0, st, st + mid);
				if (visit[n - 1][n - 1] == true) {
					ok = true;
					break;
				}
			}
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(visit[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			// Cái chỗ right = mid; left = mid + 1; phải test biên thật kỹ
			if (ok) {
				right = mid;
				ans = mid;
			}

			else
				left = mid + 1;
		}
		System.out.println(ans);
		// }

	}

	// Chạy trên server công ty thì AC 100/100. còn trên spoj thì time limited
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("MountainWalking.txt"));
		MountainWalking m = new MountainWalking();
		m.solution();
	}

}
