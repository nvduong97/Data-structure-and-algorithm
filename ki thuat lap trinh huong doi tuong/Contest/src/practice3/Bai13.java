package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
/*
 * testcase:
5
2 3 5
1 3
1 2
5
1 4
 */
public class Bai13 { // chuyen danh sach ke sang ma tran ke
	Scanner sc = new Scanner(System.in);
	int n, a, b;
	int map[][];
	String dinh, dinhKe[];

	void solution() {
		n = sc.nextInt();
		//System.out.println(n);
		sc.nextLine();
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			dinh = sc.nextLine();
			dinhKe = dinh.split(" ");
			for (String j : dinhKe) {
				int chiSo = Integer.valueOf(j);
				map[i][chiSo] = map[chiSo][i] = 1;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai13 bai1 = new Bai13();
		bai1.solution();
	}

}
