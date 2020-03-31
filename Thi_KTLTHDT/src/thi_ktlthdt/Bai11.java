package thi_ktlthdt;
import java.util.*;
public class Bai11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
                    int n = sc.nextInt();
                    long k = sc.nextLong();
                    System.out.println(tim(n, k));
		}
	}
	public static int tim(int n, long k) {
		long x = (long)Math.pow(2, n - 1);
                if (k == x) return n;
		if (k < x) return tim(n - 1, k);
		else	return tim(n - 1, k - x);
	}
}
