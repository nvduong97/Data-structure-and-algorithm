package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChenMang {
	Scanner sc = new Scanner(System.in);
	int testCase, n, m, p;
	List<Integer> list1 = new ArrayList<Integer>();
	List<Integer> list2 = new ArrayList<Integer>();

	void solution() {
		testCase = sc.nextInt();
		sc.nextLine();
		//System.out.println(testCase);
		for (int tc = 1; tc <= testCase; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			p = sc.nextInt();
			//System.out.println(n + " " + m + " " + p);
			for (int i = 0; i < n; i++) {
				list1.add(sc.nextInt());
				System.out.print(list1.get(i) + " ");
			}
			System.out.println();
			for (int i = 0; i < m; i++) {
				list2.add(sc.nextInt());
				System.out.print(list2.get(i) + " ");
			}
			for (int i = p; i < p + m; i++) {
				list1.add(i, list2.get(i-p));
			}
			System.out.println();
			for (int i = 0; i < list1.size(); i++) {
				System.out.print(list1.get(i) + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		ChenMang chenMang = new ChenMang();
		chenMang.solution();
	}

}
