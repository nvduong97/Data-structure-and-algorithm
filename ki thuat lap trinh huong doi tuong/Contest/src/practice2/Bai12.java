package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

// chia de tri
// int la so, BigInteger la doi tuong, no luu tru kieu String nen co nhieu ham tinh toan, co ham chia lay du
public class Bai12 { // luy thua
	Scanner sc = new Scanner(System.in);
	int t, n, k;
	BigInteger modulo = new BigInteger(1000000007 + "");

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			k = sc.nextInt();
			BigInteger b1 = new BigInteger(n + "");
			BigInteger b2 = new BigInteger(k + "");
			BigInteger result = b1.modPow(b2, modulo);
			System.out.println(result);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai12 bai9 = new Bai12();
		bai9.solution();
	}

}
