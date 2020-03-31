package practice1;

import java.util.Scanner;

public class Bai8ThamKhao {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t;
		String s;
		t = in.nextInt();
		while (t-- > 0) {
			s = in.next();
			if (check(s))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	public static boolean check(String s) {
		int n = s.length(), d = 0, c = n - 1;
		while (d < c) {
			if ((s.charAt(c) - '0') % 2 != 0)
				return false;
			if (s.charAt(d) != s.charAt(c))
				return false;
			d++;
			c--;
		}
		return true;
	}
}