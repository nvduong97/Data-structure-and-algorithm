package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai5 { // to hop
	final int MODULO = 1000000007;
	Scanner sc = new Scanner(System.in);
	int n, k, t;
	int C[];
	int toHop(int n, int k) {
		C[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = Math.min(i, k); j > 0; j--) {
				C[j] = (C[j] % MODULO + C[j - 1] % MODULO) % MODULO;
			}
		}
		return C[k];
	}
	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			C = new int[n + 1];
			System.out.println(toHop(n, k));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai5 bai1 = new Bai5();
		bai1.solution();
	}

}
