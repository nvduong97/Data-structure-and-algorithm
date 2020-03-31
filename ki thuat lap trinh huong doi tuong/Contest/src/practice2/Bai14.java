package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai14 { // dem day
	Scanner scanner = new Scanner(System.in);
	int t;
	long n;
	final long modulo = 123456789;

	long pow(long n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 2;
		long x = pow(n / 2);
		if (n % 2 == 0)
			return x * x % modulo;
		return (2 * x % modulo) * x % modulo;
	}

	void solution() {
		t = scanner.nextInt();
		while (t-- > 0) {
			n = scanner.nextLong();
			System.out.println(pow(n - 1));
		}
	}

	public static void main(String args[]) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai14 bai14 = new Bai14();
		bai14.solution();
	}
}
