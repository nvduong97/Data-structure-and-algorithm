package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * có bao nhiêu số có n chữ số mà tổng bằng k thì tương đương với tổng các số có n - 1 chữ số mà tổng bằng (k - 1), (k - 2), ..., (k - 9)
	à thêm cả thằng k nữa
 	coi như số cuối cùng có thể là 0 -> 9
 	
 	khai báo ma trận a[][] = -1 thì AC, còn để là 0 thì TLE ???
 */
public class Bai8 {// SỐ CÓ TỔNG CHỮ SỐ BẰNG K
	final int MODULO = 1000000007;
	Scanner sc = new Scanner(System.in);
	int t, n, k;
	long a[][];
	long process(int n, int k) {
		if (n == 0) {
			if (k == 0)
				return 1;
			return 0;
		}
		if (a[n][k] != -1) {
			return a[n][k];
		}
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			if (k - i >= 0) {
				sum += process(n - 1, k - i);
				sum %= MODULO;
			}
		}
		a[n][k] = sum;
		return sum;

	}

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			if (k > 9 * n) {
				System.out.println(0);
			} else if (n == 1 && k == 0) {
				System.out.println(1);
			} else {
				a = new long[105][50005];
				for (int i = 0; i < 105; i++) {
					for (int j = 0; j < 50005; j++) {
						a[i][j] = -1;
					}
				}
				long result = 0;
				for (int i = 1; i <= 9; i++) {
					if (k - i >= 0) {
						result += process(n - 1, k - i);
					}
				}
				System.out.println(result % MODULO);
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai8 bai8 = new Bai8();
		bai8.solution();
	}

}
