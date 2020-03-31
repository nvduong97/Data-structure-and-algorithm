package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// danh sach canh => ma tran ke => danh sach ke
public class Bai10 { // chuyen tu danh sach canh sang danh sach ke
	Scanner sc = new Scanner(System.in);
	int n, m;// n dinh, m canh
	int a, b;
	int map[][];

	void solution() {
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai10 bai10 = new Bai10();
		bai10.solution();
	}

}
