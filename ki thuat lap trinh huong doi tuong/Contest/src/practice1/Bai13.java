package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai13 {
	Scanner sc = new Scanner(System.in);
	int testCase, n, k;
	int arr[];

	void result() {
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i]);
		}
		System.out.println();
	}

	boolean check(int k) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += arr[i];
		}
		if (sum == k)
			return true;
		return false;
	}

	void backTrack(int i) {
		if (i == n + 1) {
			if (check(k)) {
				result();
				return;
			}
			return;
		}
		for (int j = 0; j <= 1; j++) {
			arr[i] = j;
			backTrack(i + 1);
		}
	}

	void solution() {
		testCase = sc.nextInt();
		while (testCase-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			arr = new int[n + 1];
			backTrack(1);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai13.txt"));
		Bai13 b = new Bai13();
		b.solution();
	}
}
