package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChuyenMaTranKeSangDanhSachKe {
	Scanner sc = new Scanner(System.in);
	int n, map[][];

	void solution() {
		n = sc.nextInt();
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
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
		ChuyenMaTranKeSangDanhSachKe chuyenMaTranKeSangDanhSachKe = new ChuyenMaTranKeSangDanhSachKe();
		chuyenMaTranKeSangDanhSachKe.solution();
	}

}
