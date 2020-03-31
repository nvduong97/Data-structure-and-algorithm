package practice;
/*
 * http://www.hoangvancong.com/2016/10/18/backtracking-nang-cap-may-tinh/
 * https://alexishuuuocn.wordpress.com/2019/07/13/nang-cap-may-tinh/
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NangCapMayTinh2 {
	Scanner sc = new Scanner(System.in);
	int t, n, m, ans;
	int arrGia[][];
	int mua[];
	int visit[];

	void init() {
		ans = 9999999;
		visit = new int[n + 10];
		mua = new int[n + 10];
		arrGia = new int[n + 10][n + 10];
	}

	void backTrack(int num, int sum) {
		// vì mua sao cho tốn ít tiền nhất
		if (sum > ans) {
			return;
		}
		if (num == n + 1) {
			if (sum < ans) {
				ans = sum;
			}
			return;
		}
		if (mua[num] == 1) {
			for (int i = 0; i <= n; i++) {
				// do mua giá từng linh kiện trên chợ trời thì rẻ hơn nhưng mua theo gói thì
				// trên gói ưu đãi trên mạng rẻ hơn
				if (visit[i] == 0 && arrGia[num][i] != 0) {
					// xét đầu tiên là mua giá linh kiện trên chợ trời, i==0 là trường hợp cột số 0
					// mua linh kiện trên chợ trời
					if (i != 0) {
						visit[i] = 1;
					}
					System.out.println(num + " - " + i);
					backTrack(num + 1, sum + arrGia[num][i]);
					visit[i] = 0;
				} else if (visit[i] == 1 && arrGia[num][i] != 0) {
					backTrack(num + 1, sum);
				}
			}
		} else {
			backTrack(num + 1, sum);
		}
	}

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			init();
			for (int i = 1; i <= n; i++) {
				arrGia[i][0] = sc.nextInt();
			}
			m = sc.nextInt();
			for (int i = 1; i <= m; i++) {
				int gia = sc.nextInt();
				int k = sc.nextInt();
				for (int j = 1; j <= k; j++) {
					int index = sc.nextInt();
					arrGia[index][i] = gia;
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j <= n; j++) {
					System.out.print(arrGia[i][j] + " ");
				}
				System.out.println();
			}
			int L = sc.nextInt();
			for (int i = 1; i <= L; i++) {
				int index = sc.nextInt();
				mua[index] = 1;
			}
			System.out.println();
			for (int i = 1; i <= n; i++) {
				System.out.print(mua[i] + " ");
			}
			System.out.println();
			backTrack(1, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("NangCapMayTinh.txt"));
		NangCapMayTinh2 m = new NangCapMayTinh2();
		m.solution();
	}

}