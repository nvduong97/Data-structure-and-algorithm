package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
// Thấy thầy nói là bỏ ko thi bài này
public class Bai11 { // khuyen mai
	Scanner sc = new Scanner(System.in);
	int n, k, a[], b[], c[];

	void solution() {
		n = sc.nextInt();
		k = sc.nextInt();
		a = new int[n];
		b = new int[n];
		c = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			c[i] = Math.abs(a[i] - b[i]);
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (c[i] > c[j]) {
					int temp = c[i];
					c[i] = c[j];
					c[j] = temp;

					temp = a[i];
					a[i] = a[j];
					a[j] = temp;

					temp = b[i];
					b[i] = b[j];
					b[j] = temp;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] > b[i]) {
				count++;
			}
		}
		int sum = 0;
		if (count == n) {
			for (int i = 0; i < k; i++) {
				sum += a[i];
			}
			for (int i = k; i < n; i++) {
				sum += b[i];
			}
			System.out.println(sum);
		} else {
			for (int i = 0; i < n; i++) {
				if (b[i] > a[i]) {
					sum += a[i];
				} else {
					sum += b[i];
				}
			}
			System.out.println(sum);
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai11 bai11 = new Bai11();
		bai11.solution();
	}
}
