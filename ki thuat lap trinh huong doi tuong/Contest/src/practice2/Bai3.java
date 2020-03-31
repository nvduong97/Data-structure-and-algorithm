package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai3 { // sap xep chen
	Scanner sc = new Scanner(System.in);
	int n;
	int arr[];

	List<Integer> list = new ArrayList<Integer>();

	void solution() {
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Buoc 0: " + arr[0]);
		for (int i = 1; i < n; i++) {
			for (int a = 0; a < i; a++) {
				for (int b = a + 1; b <= i; b++) {
					if (arr[a] > arr[b]) {
						int temp = arr[a];
						arr[a] = arr[b];
						arr[b] = temp;
					}
				}
			}
			System.out.print("Buoc " + i + ": ");
			for (int k = 0; k <= i; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}
//		int key;
//		for (int i = 1; i < n; i++) {
//			key = a[i];
//			int j = i - 1;
//			while (j >= 0 && a[j] > key) {
//				a[j + 1] = a[j];
//				j--;
//			}
//			a[j + 1] = key;
//			System.out.print("Buoc " + (i) + ": ");
//			for (int k = 0; k <= i; k++) {
//				System.out.print(a[k] + " ");
//			}
//			System.out.println();
//		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai3 bai1 = new Bai3();
		bai1.solution();
	}

}
