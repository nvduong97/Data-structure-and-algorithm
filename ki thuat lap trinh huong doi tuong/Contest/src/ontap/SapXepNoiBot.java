package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SapXepNoiBot {
	Scanner sc = new Scanner(System.in);
	int n, a[];

	void solution() {
		n = sc.nextInt();
		a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 1; i <= n - 1; i++) {
			boolean check = false;
			for (int j = 1; j <= n - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					check = true;
				}
			}
			if (check == false) {
				break;
			} else {
				System.out.print("Buoc " + i + ": ");
				for (int k = 1; k <= n; k++) {
					System.out.print(a[k] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		SapXepNoiBot sapXepChon = new SapXepNoiBot();
		sapXepChon.solution();
	}

}
