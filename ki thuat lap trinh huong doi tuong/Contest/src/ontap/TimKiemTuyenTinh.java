package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TimKiemTuyenTinh {
	Scanner sc = new Scanner(System.in);
	int t, n, k;
	int a[];

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			boolean check = false;
			int viTri = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] == k) {
					check = true;
					viTri = i;
					break;
				}
			}
			if (check == true) {
				System.out.println(viTri + 1);
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		TimKiemTuyenTinh timKiemTuyenTinh = new TimKiemTuyenTinh();
		timKiemTuyenTinh.solution();
	}

}
