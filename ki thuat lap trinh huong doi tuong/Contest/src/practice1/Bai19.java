package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai19 {
	Scanner sc = new Scanner(System.in);
	int t, n;
	int res[] = new int[505];
	boolean visit[] = new boolean[505];

	void init() {
		int dem = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(9);
		// 1 <= n <= 500 (chay tu 0-499) tuong duong
		while (dem < 500) { // cho nay dem <500 thi OK, tu 501 tro di thi don't run
			int top = queue.peek();
			queue.remove();
			for (int i = 1; i <= 500 && i <= top; i++) {
				if (top % i == 0 && !visit[i]) {
					visit[i] = true;
					dem++;
					res[i] = top;
				}
			}
			queue.add(top * 10);
			queue.add(top * 10 + 9);
		}
	}

	void solution() {
		t = sc.nextInt();
		init();
		while (t-- > 0) {
			n = sc.nextInt();
			System.out.println(res[n]);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Bai19.txt"));
		Bai19 bai19 = new Bai19();
		bai19.solution();
	}

}
