package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhanTuBenPhaiDauTienLonHon {
	Scanner sc = new Scanner(System.in);
	int t, n, a[];

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < n - 1; i++) {
				boolean check = false;
				for (int j = i + 1; j < n; j++) {
					if (a[i] < a[j]) {
						check = true;
						System.out.print(a[j] + " ");
						break;
					}
				}
				if(check == false) {
					System.out.print("-1 ");
				}
			}
			System.out.println(-1);
			//a = null;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		PhanTuBenPhaiDauTienLonHon phaiDauTienLonHon = new PhanTuBenPhaiDauTienLonHon();
		phaiDauTienLonHon.solution();
	}
}
