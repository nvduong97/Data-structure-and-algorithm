package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai6 {
	int hang, cot, testCase;
	int arr1[][]; // ma tran
	int arr2[][]; // ma tran chuyen vi
	int arr3[][];
	Scanner sc = new Scanner(System.in);
	int n;

	void solution() {
		testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.println("Test " + tc + ": ");
			hang = sc.nextInt();
			cot = sc.nextInt();
			arr1 = new int[hang + 1][cot + 1];
			arr2 = new int[cot + 1][hang + 1];
			arr3 = new int[hang + 1][hang + 1];
			for (int i = 0; i < hang; i++) {
				for (int j = 0; j < cot; j++) {
					n = sc.nextInt();
					arr1[i][j] = n;
					arr2[j][i] = n;
				}
			}

			for (int i = 0; i < hang; i++) {
				for (int j = 0; j < cot; j++) {
					for (int k = 0; k < hang; k++) {
						arr3[i][k] += arr1[i][j] * arr2[j][k];
					}
				}
			}
			for (int i = 0; i < hang; i++) {
				for (int j = 0; j < hang; j++) {
					System.out.print(arr3[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai6.txt"));
		Bai6 b = new Bai6();
		b.solution();
	}
}
