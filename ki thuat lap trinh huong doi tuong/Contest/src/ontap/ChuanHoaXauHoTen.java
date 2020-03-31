package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChuanHoaXauHoTen {
	Scanner sc = new Scanner(System.in);
	int testCase;
	String str;

	void process(String s) {
		s = s.trim();
		s = s.toLowerCase();
		s = s.replaceAll("\\s++", " ");
		String s2[] = s.split(" ");
		//System.out.println(s2.length);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 1; i < s2.length; i++) {
			stringBuilder.append(s2[i].toUpperCase().charAt(0));
			stringBuilder.append(s2[i].substring(1) + " ");
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append(", " + s2[0].toUpperCase());
		System.out.println(stringBuilder.toString());
	}

	void solution() {
		testCase = sc.nextInt();
		sc.nextLine();
		while (testCase-- > 0) {
			str = sc.nextLine();
			process(str);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		ChuanHoaXauHoTen chuanHoaXauHoTen = new ChuanHoaXauHoTen();
		chuanHoaXauHoTen.solution();
	}
}
