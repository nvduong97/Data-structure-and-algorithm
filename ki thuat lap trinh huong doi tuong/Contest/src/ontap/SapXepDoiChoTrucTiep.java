package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SapXepDoiChoTrucTiep {
	Scanner sc = new Scanner(System.in);
	int n, a[];

	void solution() {
		n = sc.nextInt();
		a = new int[n + 1];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			System.out.print("Buoc " + i + ": ");
			for (int k = 0; k < n; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		SapXepDoiChoTrucTiep sapXepDoiChoTrucTiep = new SapXepDoiChoTrucTiep();
		sapXepDoiChoTrucTiep.solution();
	}

}
