package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Bai10 { // mua ca phe
	Scanner sc = new Scanner(System.in);
	int n, m, a[], b[];

	int binarySearchCount(int n, int key) {
		int count = 0;
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (key >= a[mid]) {
				count = mid + 1;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return count;
	}

	void solution() {
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		m = sc.nextInt();
		b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}
		Arrays.sort(a);
		for (int i = 0; i < m; i++) {
			System.out.println(binarySearchCount(n, b[i]));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai10 bai10 = new Bai10();
		bai10.solution();
	}
}
