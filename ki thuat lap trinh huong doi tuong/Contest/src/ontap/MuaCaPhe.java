package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MuaCaPhe {
	Scanner sc = new Scanner(System.in);
	int n, m, a[], b[];

	void solution() {
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		m = sc.nextInt();
		b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (b[i] >= a[j]) {
					count++;
				} else {
					break;
				}
			}
			System.out.println(count);
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		MuaCaPhe muaCaPhe = new MuaCaPhe();
		muaCaPhe.solution();
	}

}
