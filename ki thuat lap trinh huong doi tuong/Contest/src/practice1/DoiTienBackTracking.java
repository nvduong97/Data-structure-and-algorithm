package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DoiTienBackTracking {
	Scanner sc = new Scanner(System.in);
	int n, s;
	int a[];
	int min = 9999999;
	int soTo = 0;

	void backTrack(int i) {
		for (int j = s / a[i]; j >= 0; j--) {
			soTo += j;
			s -= (j * a[i]);
			if (s == 0) {
				min = soTo;
			} else if (i < n - 1 && soTo + s / a[i + 1] < min) {
				backTrack(i + 1);
			}
			soTo -= j;
			s += (j * a[i]);
		}
	}

	void solution() {
		n = sc.nextInt();
		s = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		// sap xep giam dan
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		backTrack(0);
		System.out.println(min);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai20.txt"));
		DoiTienBackTracking doiTien = new DoiTienBackTracking();
		doiTien.solution();
	}

}
