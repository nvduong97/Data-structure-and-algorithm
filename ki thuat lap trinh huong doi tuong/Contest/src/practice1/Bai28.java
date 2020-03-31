package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai28 {
	Scanner sc = new Scanner(System.in);
	int a, b;
	int sumMin(int x, int y) {
		String s1 = String.valueOf(x).replaceAll("6", "5");
		String s2 = String.valueOf(y).replaceAll("6", "5");
		return Integer.valueOf(s1) + Integer.valueOf(s2);
	}

	int sumMax(int x, int y) {
		String s1 = String.valueOf(x).replaceAll("5", "6");
		String s2 = String.valueOf(y).replaceAll("5", "6");
		return Integer.valueOf(s1) + Integer.valueOf(s2);
	}

	void solution() {
		a = sc.nextInt();
		b = sc.nextInt();
		int min = sumMin(a, b);
		int max = sumMax(a, b);
		System.out.println(min + " " + max);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai28.txt"));
		Bai28 bai28 = new Bai28();
		bai28.solution();
	}

}
