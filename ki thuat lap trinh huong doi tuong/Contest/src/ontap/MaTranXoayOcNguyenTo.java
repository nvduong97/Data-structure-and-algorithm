package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MaTranXoayOcNguyenTo {
	Scanner sc = new Scanner(System.in);
	int testCase, n, a[][];

	boolean nguyenTo(int n) {
		if (n < 2)
			return false;
		else {
			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0)
					return false;
			}
			return true;
		}
	}

	void solution() {
		testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			n = sc.nextInt();
			a = new int[n + 1][n + 1];
			int giaTri = n * n;
			int m = n;
			int diChuyen = 1;
			int k = 2;
			int dem = 0;
			while (dem < n * n && giaTri < n * n) {
				if (nguyenTo(k)) {
					dem++;
					// trai sang phai
					for (int i = diChuyen; i <= n; i++) {
						if (a[diChuyen][i] == 0) {
							a[diChuyen][i] = k;
							giaTri--;
							break;
						}
					}
					// tren xuong duoi
					for (int i = diChuyen + 1; i <= n; i++) {
						if (a[i][n] == 0) {
							a[i][n] = k;
							giaTri--;
							break;
						}
					}
					// phai sang trai
					for (int i = n - 1; i >= diChuyen + 1; i--) {
						if (a[n][i] == 0) {
							a[n][i] = k;
							giaTri--;
							break;
						}
					}
					// duoi len tren
					for (int i = n - 1; i >= diChuyen + 1; i--) {
						if (a[i][diChuyen] == 0) {
							a[i][diChuyen] = k;
							giaTri--;
							break;
						}
					}
					// thu nho ma tran
					diChuyen++;
					n--;
				}
				k++;
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
		MaTranXoayOcNguyenTo maTranXoayOcNguyenTo = new MaTranXoayOcNguyenTo();
		maTranXoayOcNguyenTo.solution();
	}

}
