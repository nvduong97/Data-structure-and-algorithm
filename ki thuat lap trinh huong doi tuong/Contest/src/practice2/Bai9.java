package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai9 { // tim kiem nhi phan
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
			int viTri = 0;
			boolean check = false;
			for (int i = 0; i < n; i++) {
				if (a[i] == k) {
					viTri = i + 1;
					check = true;
					break;
				}
			}
			if (check == true) {
				System.out.println(viTri);
			} else
				System.out.println("NO");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai9 bai9 = new Bai9();
		bai9.solution();
	}

}
