package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChuyenDanhSachKeSangMaTranKe {
	Scanner sc = new Scanner(System.in);
	int n, map[][];
	String dinh, dinhKe[];

	void solution() {
		n = sc.nextInt();
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
		ChuyenDanhSachKeSangMaTranKe chuyenDanhSachKeSangMaTranKe = new ChuyenDanhSachKeSangMaTranKe();
		chuyenDanhSachKeSangMaTranKe.solution();
	}
}
