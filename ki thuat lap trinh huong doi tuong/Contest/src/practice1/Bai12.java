package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai12 {
	Scanner sc = new Scanner(System.in);
	int t;
	String s;

	void solution() {
		t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			StringBuilder s2 = new StringBuilder();
			StringBuilder s1 = new StringBuilder();
			s = sc.nextLine();
			s = s.trim();
			s = s.toLowerCase();
			s = s.replaceAll("\\s+", " ");
			String temp[] = s.split(" ");

			for (int i = 0; i <= temp.length - 1; i++) {
				s1 = new StringBuilder(temp[i]);
				s1.setCharAt(0, Character.toUpperCase(s1.charAt(0)));
				s2.append(s1 + " ");
			}
			s2.deleteCharAt(s2.length() - 1);
			System.out.println(s2.toString());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai12.txt"));
		Bai12 b = new Bai12();
		b.solution();
	}

}
