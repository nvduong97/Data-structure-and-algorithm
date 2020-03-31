package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
/*
 * https://www.spoj.com/PTIT/problems/SSAM219A/fbclid=IwAR2f-ESSuz_dOIGTeKoB5yqdNETqNTeky--Q-rHfSjiBlmBxCKoa1tcUVGA
 * quy hoạch động, có bao nhiêu cách đi đến bậc thứ n thì tương đương với có tổng bao nhiêu cách đi đến các bậc (n - k), (n - k + 1), ..., (n - 1) (or (n-1), (n-2),...(n-k))
 * quy về bài toán tổ hợp C(k,n)
 */
import java.util.Scanner;

public class Bai7 { // bac thang
	Scanner sc = new Scanner(System.in);
	final int MODULO = 1000000007;
	int t, n, k; int f[];
	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			f = new int[100005];
			f[0] = 1; f[1] = 1;
			// tổng số cách đi k bậc
			for (int i = 2; i <= k; i++) {
				for (int j = 0; j < i; j++) {
					f[i] += f[j];
					f[i] = f[i] % MODULO;
				}
			}
			// tổng số cách đi tới bậc thứ n
			for (int i = k + 1; i <= n; i++) {
				for (int j = i - k; j < i; j++) {
					f[i] += f[j];
					f[i] = f[i] % MODULO;
				}
			}
			System.out.println(f[n]);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai7 bai7 = new Bai7();
		bai7.solution();

	}
}
