package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai1 {
	int testCase, n;
	Scanner sc = new Scanner(System.in);

	void solution() {
		testCase = sc.nextInt();
		while (testCase-- > 0) {
			n = sc.nextInt();
			long f0 = 1, f1 = 1, f2 = 0;
			if (n == 1 || n == 2)
				System.out.println(1);
			else {
				for (int i = 3; i <= n; i++) {
					f2 = f0 + f1;
					f0 = f1;
					f1 = f2;
				}
				System.out.println(f2);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai1 b = new Bai1();
		b.solution();
	}
}
