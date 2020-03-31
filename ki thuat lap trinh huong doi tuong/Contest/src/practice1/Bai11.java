package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai11 {

	Scanner sc = new Scanner(System.in);
	int t, n;
	String s, s1;
	List<String> list = new ArrayList<>();

	void solution() {
		t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			StringBuilder s2 = new StringBuilder();
			s = sc.nextLine();
			s = s.trim();
			s = s.toLowerCase();
			s = s.replaceAll("\\s+", " ");
			String temp[] = s.split(" ");
			s2.append(temp[temp.length - 1]);
			for (int i = 0; i <= temp.length - 2; i++) {
				s2.append(temp[i].charAt(0));
			}
			list.add(s2.toString());
			int count = 0;
			for (String str : list) {
				if (s2.toString().equals(str)) {
					count++;
				}
			}
			if (count > 1) {
				s2.append(count);
			}
			s2.append("@ptit.edu.vn");
			System.out.println(s2.toString());
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai11.txt"));
		Bai11 b = new Bai11();
		b.solution();
	}

}
