package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* đề bài là: cho 1 hình chữ nhật kích thước nxn chỉ gồm các giá trị 0 và 1
 * nhiệm vụ là đếm xem có bao nhiêu hình chữ nhật con gồm toàn 0 và toàn 1
 * giả sử 1 hcn 8x8 thì sẽ có tồn tại các hcn toàn 1 or toàn 0 vs kích thước 1x1, 2x2, 3x3, 4x4,5x5,6x6,7x7,8x8
 * do mình quên ko copy đề bài vs test case mẫu nên mai sẽ lên cty copy đề vs test case mẫu về
 * Hình như mình copy thiếu testcase nên code ko chạy được ấy
 */
public class CuttingaPieceofColoredPaper_CatGiay {
	static int t, n, count1, count0;
	static int[][] data;

	static void backTrack(int x, int y, int length) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += data[i][j];
			}
		}

		if (sum == 0) {
			count0++;
			return;
		}
		if (sum == n * n) {
			count1++;
			return;
		} else {
			backTrack(x, y, length / 2);
			backTrack(x, y + length / 2, length / 2);
			backTrack(x + length / 2, y, length / 2);
			backTrack(x + length / 2, y + length / 2, length / 2);
		}
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("CuttingaPieceofColoredPaper_CatGiay.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			sc.nextLine();
			//System.out.println(n);
			data = new int[n + 1][n + 1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			count0 = 0;
			count1 = 0;
			backTrack(0, 0, n);
			System.out.println("Case #" + tc + " " + count0 + " " + count1);
		}
	}

}
