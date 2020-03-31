package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChuyenDanhSachCanhSangDanhSachKe {
	Scanner sc = new Scanner(System.in);
	int n, m, map[][], start, end;

	void solution() {
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			start = sc.nextInt();
			end = sc.nextInt();
			map[start][end] = map[end][start] = 1;
		}
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(map[i][j]==1) {
					System.out.print(j+" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		ChuyenDanhSachCanhSangDanhSachKe chuyenDanhSachCanhSangDanhSachKe = new ChuyenDanhSachCanhSangDanhSachKe();
		chuyenDanhSachCanhSangDanhSachKe.solution();
	}

}
