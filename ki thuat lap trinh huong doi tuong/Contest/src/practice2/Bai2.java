package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai2 { // sap xep chon
	Scanner sc = new Scanner(System.in);
	int n;
	int a[];

	void solution() {
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i <= n - 2; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
			System.out.print("Buoc " + (i + 1) + ": ");
			for (int k = 0; k < n; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai2 bai1 = new Bai2();
		bai1.solution();
	}

}
