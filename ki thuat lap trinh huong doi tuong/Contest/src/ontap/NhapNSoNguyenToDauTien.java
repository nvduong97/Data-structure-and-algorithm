package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NhapNSoNguyenToDauTien {
	Scanner sc = new Scanner(System.in);
	int n;

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
		n = sc.nextInt();
		int dem = 0;
		int i = 2;
		while (dem < n) {
			if (nguyenTo(i)) {
				dem++;
				System.out.print(i + " ");
			}
			i++;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		NhapNSoNguyenToDauTien nhapNSoNguyenToDauTien = new NhapNSoNguyenToDauTien();
		nhapNSoNguyenToDauTien.solution();
	}

}
