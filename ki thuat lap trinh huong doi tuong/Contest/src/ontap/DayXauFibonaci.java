package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// so phan tu xau fibonaci thu n bang so fibonaci thu n
public class DayXauFibonaci {
	Scanner sc = new Scanner(System.in);
	int t, n, k, f[];

	char search(int n, int k) {
		if (n == 1)
			return 'A';
		if (n == 2)
			return 'B';
		if (k <= f[n - 2])
			return search(n - 2, k);
		return search(n -1, k - f[n-2]);
		
	}

	void solution() {
		f = new int[93];
		f[1] = 1;
		for (int i = 2; i <= 92; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			System.out.println(search(n, k));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		DayXauFibonaci dayXauFibonaci = new DayXauFibonaci();
		dayXauFibonaci.solution();
	}

}
