package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bai6_ThamKhao {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.setIn(new FileInputStream("Bai1.txt"));
		int n;
		List<String> list = new ArrayList<>();
		n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			list.add(sc.next());
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

	}
}
