package luyentap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * Cho n <= 10 thì backTrack được, còn n mà 15 thì time out ngay
 */
public class BanBongBay {
	Scanner sc = new Scanner(System.in);
	int t, n, ans;
	int arr[], visit[];

	void init() {
		ans = 0;
		arr = new int[n + 2];
		visit = new int[n + 2];
	}

	void backTrack(int index, int count) {
		if (index == n + 1) {
			if (count > ans) {
				ans = count;
			}
			return;
		}
		for (int i = 1; i <= n; i++) {
			// TH1
			if (visit[i] == 0 && visit[i + 1] == 0 && visit[i - 1] == 0) {
				visit[i] = 1;
				backTrack(index + 1, count + arr[i + 1] * arr[i - 1]);
				visit[i] = 0;
			}
			// TH2: Trai
			if (visit[i] == 0 && visit[i - 1] == 1 && visit[i + 1] == 0) {
				visit[i] = 1;
				backTrack(index + 1, count + arr[i + 1]);
				visit[i] = 0;
			}
			// TH3: Phai
			if (visit[i] == 0 && visit[i - 1] == 0 && visit[i + 1] == 1) {
				visit[i] = 1;
				backTrack(index + 1, count + arr[i - 1]);
				visit[i] = 0;
			}
			// TH4
			if (visit[i] == 0 && visit[i + 1] == 1 && visit[i - 1] == 1) {
				visit[i] = 1;
				backTrack(index + 1, count + arr[i]);
				visit[i] = 0;
			}
		}
	}

	void solution() {
		t = sc.nextInt();
		// System.out.println("t = "+t);
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			// System.out.println("n = "+n);
			init();
			for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
			}
//			System.out.println("arr");
//			for(int i=1; i<=n; i++) {
//				System.out.print(arr[i]+" ");
//			}
			visit[0] = 1;
			visit[n + 1] = 1;
			for (int i = 1; i <= t; i++) {
				backTrack(1, 0);
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BanBongBay.txt"));
		BanBongBay b = new BanBongBay();
		b.solution();
	}

}
