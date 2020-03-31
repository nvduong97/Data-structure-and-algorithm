package contest1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai17_NhamChuso {
	Scanner sc = new Scanner(System.in);
	int x,y;

	int minSum(int a, int b) {
		String s1 = String.valueOf(a).replaceAll("6", "5");
		String s2 = String.valueOf(b).replaceAll("6", "5");
		return Integer.parseInt(s1) + Integer.parseInt(s2);
	}

	int maxSum(int a, int b) {
		String s1 = String.valueOf(a).replaceAll("5", "6");
		String s2 = String.valueOf(b).replaceAll("5", "6");
		return Integer.parseInt(s1) + Integer.parseInt(s2);
	}

	void solution() {
		x = sc.nextInt();
		y = sc.nextInt();
		//System.out.println(x+" "+y);
		int min = minSum(x, y);
		int max = maxSum(x, y);
		System.out.println(min + " " + max);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai28.txt"));
		Bai17_NhamChuso nhamChuSo = new Bai17_NhamChuso();
		nhamChuSo.solution();
	}

}
