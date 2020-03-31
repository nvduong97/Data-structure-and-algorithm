package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
// số phần tử xâu thứ n = số fibonaci thứ n
public class Bai15_Test {
	Scanner sc = new Scanner(System.in);
	int t, n;
	long k;
	long f[] = new long[93];

	char searchCharacter(int n, long k) {
		if (n == 1)
			return 'A';
		if (n == 2)
			return 'B';
		if (k > f[n - 2])
			return searchCharacter(n - 1, k - f[n - 2]);
		return searchCharacter(n - 2, k);

	}

	void solution() {
		f[1] = 1;
		for (int i = 2; i <= 92; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextLong();
			System.out.println(searchCharacter(n, k));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai15_Test bai15_Test = new Bai15_Test();
		bai15_Test.solution();
	}

}
