package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai7 {
	Scanner sc = new Scanner(System.in);
	int testCase, n, giaTri, diChuyen;
	int arr[][];

	void solution() {
		testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			System.out.println("Test " + tc + ":");
			n = sc.nextInt();
			arr = new int[n + 1][n + 1];
			giaTri = n * n;
			diChuyen = 1;
			int d = n;
			while (giaTri >= 1) {
				// tu trai qua phai
				for (int i = diChuyen; i <= n; i++) {
					arr[diChuyen][i] = giaTri--;
				}
				// tu tren xuong duoi
				for (int i = diChuyen + 1; i <= n; i++) {
					arr[i][n] = giaTri--;
				}
				// tu phai qua trai
				for (int i = n - 1; i >= diChuyen; i--) {
					arr[n][i] = giaTri--;
				}
				// tu duoi len tren
				for (int i = n - 1; i > diChuyen; i--) {
					arr[i][diChuyen] = giaTri--;
				}
				// thu nho ma tran
				n--;
				diChuyen++;
			}
			for (int i = 1; i <= d; i++) {
				for (int j = 1; j <= d; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai7.txt"));
		Bai7 b = new Bai7();
		b.solution();
	}
}
