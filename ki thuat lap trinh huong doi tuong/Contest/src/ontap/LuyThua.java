package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LuyThua {
	Scanner sc = new Scanner(System.in);
	int n, k, testCase;
	final int modulo = 1000000007;

	long pow(int n, int k) {
		if (k == 0)
			return 1;
		if (k % 2 == 0)
			return pow(n, k / 2) * pow(n, k / 2) % modulo;
		return (pow(n, k / 2) * pow(n, k / 2) % modulo) * n % modulo;
	}

	void solution() {
		testCase = sc.nextInt();
		while (testCase-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			System.out.println(pow(n, k));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		LuyThua luyThua = new LuyThua();
		luyThua.solution();
	}

}
