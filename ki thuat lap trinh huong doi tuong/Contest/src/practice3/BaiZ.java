package practice3;

import java.util.Scanner;

public class BaiZ {
	static int A[][] = new int[1001][1001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int i;
		String dinh, dinhKe[];
		for (i = 1; i <= n; i++) {
			dinh = sc.nextLine();
			dinhKe = dinh.split(" ");
			for (String j : dinhKe) {
				int chiSo = Integer.parseInt(j); // chuyển đổi kiểu dữ liệu từ String => int
				A[i][chiSo] = A[chiSo][i] = 1;
			}
		}
		for (i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}
}
