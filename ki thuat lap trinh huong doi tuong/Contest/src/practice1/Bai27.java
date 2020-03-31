package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai27 {
	Scanner sc = new Scanner(System.in);
	int n;
	int a[];
	int visit[];
	int min = 99999999;

	void backTrack(int index, int sum) {
		if (index == n) {
			if (sum < min) {
				min = sum;
			}
			return;
		} else {
			for (int i = 0; i < n; i++) {
				if (visit[i] == 0) {
					visit[i] = 1;
					backTrack(index + 1, sum + a[i]);
					visit[i] = 0;
				}
			}
		}
	}

	void solution() {
		n = sc.nextInt();
		a = new int[n];
		visit = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		backTrack(0, 0);
		System.out.println(min);

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai27.txt"));
		Bai27 bai27 = new Bai27();
		bai27.solution();
	}

}
