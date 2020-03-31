package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Bai5_SapXepNhanh {
	Scanner sc = new Scanner(System.in);
	int t, n;
	int a[];

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			for (int i = 0; i < n; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai5.txt"));
		Bai5_SapXepNhanh SapXepNhanh = new Bai5_SapXepNhanh();
		SapXepNhanh.solution();
	}

}
