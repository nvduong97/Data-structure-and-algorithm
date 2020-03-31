package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai16 { // so fibonaci thu n
	final long MODULO = 1000000007;
	Scanner scanner = new Scanner(System.in);
	int t, n;

	void multiplyTheMatrix(long F[][], long M[][]) {
		long a = (F[0][0] * M[0][0] % MODULO + F[0][1] * M[1][0] % MODULO) % MODULO;
		long b = (F[0][0] * M[0][1] % MODULO + F[0][1] * M[1][1] % MODULO) % MODULO;
		long c = (F[1][0] * M[0][0] % MODULO + F[1][1] * M[1][0] % MODULO) % MODULO;
		long d = (F[1][0] * M[0][1] % MODULO + F[1][1] * M[1][1] % MODULO) % MODULO;
		F[0][0] = a;
		F[0][1] = b;
		F[1][0] = c;
		F[1][1] = d;
	}

	void pow(long F[][], long n) {
		if (n == 1)
			return;
		long M[][] = new long[][] { { 1, 1 }, { 1, 0 } };
		pow(F, n / 2);
		multiplyTheMatrix(F, F);
		if (n % 2 != 0) {
			multiplyTheMatrix(F, M);
		}
	}

	long fibonaci(long n) {
		long F[][] = new long[][] { { 1, 1 }, { 1, 0 } }; // init matrix
		if (n == 1)
			return 1;
		pow(F, n - 1);
		return F[0][0];
	}

	void solution() {
		t = scanner.nextInt();
		while (t-- > 0) {
			n = scanner.nextInt();
			System.out.println(fibonaci(n));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai16 bai16 = new Bai16();
		bai16.solution();
	}

}
