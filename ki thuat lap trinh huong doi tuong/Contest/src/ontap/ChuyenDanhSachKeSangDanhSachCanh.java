package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChuyenDanhSachKeSangDanhSachCanh {
	Scanner sc = new Scanner(System.in);
	int n;
	String dinh, dinhKe[];
	int map[][];

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
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(map[i][j] == 1) {
					System.out.println(i+" "+j);
					map[i][j] = map[j][i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		ChuyenDanhSachKeSangDanhSachCanh chuyenDanhSachKeSangDanhSachCanh = new ChuyenDanhSachKeSangDanhSachCanh();
		chuyenDanhSachKeSangDanhSachCanh.solution();
	}

}
