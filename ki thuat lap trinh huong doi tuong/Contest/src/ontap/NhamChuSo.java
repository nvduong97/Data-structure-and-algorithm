package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NhamChuSo {
	Scanner sc = new Scanner(System.in);
	int a, b;

	int minSum(int x, int y) {
		String s1 = String.valueOf(x).replaceAll("6", "5");
		String s2 = String.valueOf(y).replaceAll("6", "5");
		return Integer.valueOf(s1) + Integer.valueOf(s2);
	}

	int maxSum(int x, int y) {
		String s1 = String.valueOf(x).replaceAll("5", "6");
		String s2 = String.valueOf(y).replaceAll("5", "6");
		return Integer.valueOf(s1) + Integer.valueOf(s2);
	}

	void solution() {
		a = sc.nextInt();
		b = sc.nextInt();
		System.out.println(minSum(a, b) + " " + maxSum(a, b));
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		NhamChuSo nhamChuSo = new NhamChuSo();
		nhamChuSo.solution();
	}

}
