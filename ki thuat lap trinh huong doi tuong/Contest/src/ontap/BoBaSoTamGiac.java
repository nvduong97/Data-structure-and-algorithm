package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
// for trâu
public class BoBaSoTamGiac {
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
			Arrays.sort(a);
//			for (int i = 0; i < n; i++) {
//				System.out.print(a[i] + " ");
//			}
			boolean check = false;
			for (int i = 0; i <= n - 3; i++) {
				for (int j = i + 1; j <= n - 2; j++) {
					for (int k = j + 1; k <= n - 1; k++) {
						if (a[i] + a[j] >= a[k]) {
							check = true;
							break;
						}
					}
				}
			}
			if (check == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		BoBaSoTamGiac boBaSoTamGiac = new BoBaSoTamGiac();
		boBaSoTamGiac.solution();
	}

}
