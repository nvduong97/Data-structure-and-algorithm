package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaTranXoanOcNguoc {
	Scanner sc = new Scanner(System.in);

	int t, n;
	int a[][];

	void solution() {
		t = sc.nextInt();
		//System.out.println(t);
		for (int tc = 1; tc <= t; tc++) {
			System.out.println("Test " + tc + ": ");
			n = sc.nextInt();
			//System.out.println(n);
			a = new int[n + 1][n + 1];
			int diChuyen = 1;
			int giaTri = n * n;
			int m=n;
			while (giaTri >= 1) {
				// trai qua phai
				for (int i = diChuyen; i <= n; i++) {
					a[diChuyen][i] = giaTri--;
				}
				// tren xuong duoi
				for (int i = diChuyen + 1; i <= n; i++) {
					a[i][n] = giaTri--;
				}
				// phai qua trai
				for (int i = n - 1; i >= diChuyen; i--) {
					a[n][i] = giaTri--;
				}
				// duoi len tren
				for (int i = n - 1; i >= diChuyen + 1; i--) {
					a[i][diChuyen] = giaTri--;
				}
				// thu nho ma tran
				n--;
				diChuyen++;
			}
			for (int i = 1; i <= m; i++) {
				for (int j = 1; j <= m; j++) {
					System.out.print(a[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		MaTranXoanOcNguoc maTranXoanOcNguoc = new MaTranXoanOcNguoc();
		maTranXoanOcNguoc.solution();
	}

}
