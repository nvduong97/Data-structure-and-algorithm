package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai5 {
	int hang, cot;
	int arr1[][] = new int[11][11];
	int arr2[][] = new int[11][11];
	Scanner sc = new Scanner(System.in);
	int n;

	void solution() {
		hang = sc.nextInt();
		cot = sc.nextInt();
		for (int i = 0; i < hang; i++) {
			for (int j = 0; j < cot; j++) {
				n = sc.nextInt();
				arr2[j][i] = n;
			}
		}
		for (int i = 0; i < cot; i++) {
			for (int j = 0; j < hang; j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai5.txt"));
		Bai5 b = new Bai5();
		b.solution();
	}
}
