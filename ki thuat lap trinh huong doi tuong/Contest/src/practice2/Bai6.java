package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bai6 { // sap xep khong nhanh
	Scanner sc = new Scanner(System.in);
	int n;
	List<BigInteger> list = new ArrayList<>();

	void solution() {
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			BigInteger big = new BigInteger(s+"");
			list.add(big);
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		list.clear();
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai6 bai6 = new Bai6();
		bai6.solution();
	}

}
