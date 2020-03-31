package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SapXepLaiDayCon {
	Scanner sc = new Scanner(System.in);
	int t, n, a[], a2[];

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			a = new int[n];
			a2 = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
				a2[i] = a[i];
			}
			Arrays.sort(a2);
			int position = 0;
			for (int i = 0; i < n; i++) {
				if (a[i] != a2[i]) {
					position = i;
					break;
				}
			}
			for (int i = n - 1; i >= 0; i--) {
				if (a2[i] != a[i]) {
					position = i - position + 1;
					break;
				}
			}

			if (position != 0) {
				System.out.println(position);
			} else {
				System.out.println("YES");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		SapXepLaiDayCon sapXepLaiDayCon = new SapXepLaiDayCon();
		sapXepLaiDayCon.solution();
	}

}
