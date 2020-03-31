package contest1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai3_ChenMang {
	Scanner sc = new Scanner(System.in);
	int t, n, m, p;
	int a[], b[], c[];
	List<Integer> list = new ArrayList<Integer>();

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			p = sc.nextInt();
			a = new int[n];
			b = new int[m];
			c = new int[n + m];
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}

			for (int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}
			int j = 0;
			for (int i = p; i < m + p; i++) {
				list.add(i, b[j]);
				j++;
			}
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai3_ChenMang.txt"));
		Bai3_ChenMang bai3_ChenMang = new Bai3_ChenMang();
		bai3_ChenMang.solution();
	}

}
