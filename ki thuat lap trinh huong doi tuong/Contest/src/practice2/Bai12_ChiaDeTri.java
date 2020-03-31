package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai12_ChiaDeTri { // luy thua
	Scanner sc = new Scanner(System.in);
	int t;
	long n, k;
	final long modulo = 1000000007;

	long pow(long n, long k) {
		if (k == 0)
			return 1;
		if (k == 1)
			return n;
		long x = pow(n, k / 2);
		if (k % 2 == 0)
			return x * x % modulo;
		return (n * x % modulo) * x % modulo;
	}

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextLong();
			k = sc.nextLong();
			System.out.println(pow(n, k));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai12_ChiaDeTri bai12_ChiaDeTri = new Bai12_ChiaDeTri();
		bai12_ChiaDeTri.solution();
	}

}
