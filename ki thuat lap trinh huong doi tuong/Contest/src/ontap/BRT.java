package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BRT {
	Scanner sc = new Scanner(System.in);
	int t, n, a[], b[];

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
//				System.out.print(a[i]+" ");
//			}
//			System.out.println();
			b = new int[n - 1];
			for (int i = 0; i <= n - 2; i++) {
				b[i] = a[i + 1] - a[i];
			}
//			for (int i = 0; i <= n-2; i++) {
//				System.out.print(b[i]+" ");
//			}
//			System.out.println();
			Arrays.sort(b);
//			for (int i = 0; i <= n-2; i++) {
//				System.out.print(b[i]+" ");
//			}
//			System.out.println();
			int count = 1;
			for (int i = 1; i <= n - 2; i++) {
				if (b[i] == b[0]) {
					count++;
				} else {
					break;
				}
			}
			System.out.println(b[0] + " " + count);

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		BRT brt = new BRT();
		brt.solution();
	}

}
