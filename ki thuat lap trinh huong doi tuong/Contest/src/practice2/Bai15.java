package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
/* 
 * Số i đảm bảo trong phạm vi của xâu G(N) và không quá 18 chữ số. => i khoang 10^18
 */
public class Bai15 { // day xau fibonaci
	Scanner sc = new Scanner(System.in);
	int t, n;
	long k;
	long F[] = new long[100];

	char search(int n, long k) {
		if (n == 1)
			return 'A';
		if (n == 2)
			return 'B';
		if (k <= F[n - 2])
			return search(n - 2, k);
		return search(n - 1, k - F[n - 2]);
	}

	void solution() {
		F[0] = 0;
		F[1] = 1;
		for (int i = 2; i <= 92; i++) {
			F[i] = F[i - 1] + F[i - 2];
		}
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextLong();
			System.out.println(search(n, k));
		}
	}

	public static void main(String args[]) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai15 bai15 = new Bai15();
		bai15.solution();
	}
}
