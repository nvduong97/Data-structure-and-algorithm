package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SapXepChon {
	Scanner sc = new Scanner(System.in);
	int n, a[];

	void solution() {
		n = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int min;
		for (int i = 0; i < n - 1; i++) {
			min = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			// ở đây ta chỉ cần đổi vị trí sau cùng mới đổi giá trị
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
			System.out.println("Buoc " + (i + 1) + ": ");
			for (int k = 0; k < n; k++) {
				System.out.print(a[k] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		SapXepChon sapXepChon = new SapXepChon();
		sapXepChon.solution();
	}

}
