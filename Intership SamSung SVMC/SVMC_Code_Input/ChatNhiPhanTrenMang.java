package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Bài toán
 Cho một dãy n số. 
 Với mỗi số k được nhập vào, in ra một số nằm trong dãy ban đầu, nhỏ nhất và lớn hơn hoặc bằng số k.
 (Sẽ có Q số k được nhập, Q<=100000, n<=100000).
 Trước hết ta thấy rằng có thể sort lại mảng a (gọi a là dãy số ban đầu).
 Vì vậy ta có thể giả sử a là dãy không giảm.
 
 Với thuật toán như trên, độ phức tạp là O(mn).
 giảm độ phức tạp xuống O((m+n) logn).
 */
public class ChatNhiPhanTrenMang {
	static int n, m, k;
	static int[] a;

	static void bsearch(int k) {
		int left = 0, right = n - 1;
		int i = (left + right) / 2;
		while (left != i && right != i) {
			if (a[i] > k)
				right = i;
			else
				left = i;
			i = (left + right) / 2;
		}
		for (i = left; i <= right; i++) {
			if (a[i] > k) {
				System.out.println(a[i]);
				return;
			} else
				System.out.println("Not found !");
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("ChatNhiPhanTrenMang.txt"));
		Scanner sc = new Scanner(System.in);
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
		}
		m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			k = sc.nextInt();
			bsearch(k);
		}
	}

}
