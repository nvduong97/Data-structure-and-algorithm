package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// solution: divide and conquer
public class Bai13 { // gap doi day so
	Scanner sc = new Scanner(System.in);
	int n, t;
	long k;

	int search(int n, long k) {
		long x = (long) Math.pow(2, n - 1);
		if (k == x)
			return n;
		if (k < x)
			return search(n - 1, k);
		return search(n - 1, k - x);
	}

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextLong();
			System.out.println(search(n, k));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai13 bai13 = new Bai13();
		bai13.solution();
	}

}
