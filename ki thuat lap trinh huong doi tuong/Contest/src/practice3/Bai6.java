package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Bai6 { // xau con doi xung dai nhat
	Scanner sc = new Scanner(System.in);
	int t;
	String s;
	boolean F[][];
	void solution() {
		t = sc.nextInt();
		sc.nextLine();
		while (t-- > 0) {
			s = sc.nextLine();
			int n = s.length();
			F = new boolean[n + 1][n + 1];
			for (int i = 1; i < n; i++) {
				F[i][i] = true;
			}
			System.out.println(Optimization(F, s));
		}
	}
	int Optimization(boolean F[][], String a) {
		int n = a.length();
		a = ' ' + a;
		int max = 0;
		for (int k = 1; k < n; k++) {
			for (int i = 1; i <= n - k; i++) {
				int j = i + k;
				if (a.charAt(i) == a.charAt(j)) {
					if (j - i == 1) {
						F[i][j] = true;
					} else {
						F[i][j] = F[i + 1][j - 1];
					}
				} else {
					F[i][j] = false;
				}
				if ((j - i) > max && F[i][j] == true) {
					max = j - i;
				}
			}
		}
		return max + 1;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai6 bai6 = new Bai6();
		bai6.solution();

	}

}
