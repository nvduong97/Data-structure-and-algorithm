package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai17 { // luy thua ma tran
	final long MODULO = 1000000007;
	Scanner scanner = new Scanner(System.in);
	long t, n, k;
	long F[][];

	long[][] multiplyTheMatrix(long A[][], long B[][]) {
		long[][] C = new long[(int) n][(int) n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					C[i][k] = (C[i][k] % MODULO + A[i][j] * B[j][k] % MODULO) % MODULO;
				}
			}
		}
		return C;
	}

	long[][] power(long F[][], long k) {
		if (k == 1)
			return F;
		long M[][] = power(F, k / 2);
		if (k % 2 == 0)
			return multiplyTheMatrix(M, M);
		return multiplyTheMatrix(multiplyTheMatrix(F, M), M);
	}

	void solution() {
		t = scanner.nextInt();
		while (t-- > 0) {
			n = scanner.nextLong();
			k = scanner.nextLong();
			F = new long[(int) n][(int) n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					F[i][j] = scanner.nextLong();
				}
			}
			long M[][] = power(F, k);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(M[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai17 bai17 = new Bai17();
		bai17.solution();
	}

}
