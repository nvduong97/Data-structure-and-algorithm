package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * https://alexishuuuocn.wordpress.com/2019/07/07/colormaping-to-mau-ban-do/
 */
public class ColorMaping_ToMauBanDo {
	static int testCase, soQuocGia, soDuongBienGioi, x, y, check;
	static int[][] map;
	static int[] visitColor;

	static void backTrack(int index, int color) {
		if (visitColor[index] == color) {
			return;
		}
		if (visitColor[index] == 1 - color) {
			check = -1;
			return;
		} else {
			if (visitColor[index] == -1) {
				visitColor[index] = color;
			}
			for (int i = 1; i <= soQuocGia; i++) {
				if (map[index][i] == 1) {
					backTrack(i, 1 - color);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("ColorMaping_ToMauBanDo.txt"));
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			soQuocGia = sc.nextInt();
			soDuongBienGioi = sc.nextInt();
			map = new int[soQuocGia+1][soQuocGia+1];
			visitColor = new int[soQuocGia+1];
			// vì 2 quốc gia cạnh nhau có đường biên giới với nhau coi như trong ma trận 2 chiều
			for (int i = 0; i < soDuongBienGioi; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				map[x][y] = 1;
				map[y][x] =1;
			}
			// đánh dấu là chưa quốc gia nào tô màu
			for(int i=1; i<=soQuocGia; i++) {
				visitColor[i] = -1;
			}
			check = 0;
			// bắt đầu tô màu quốc gia số 1 vs màu 0
			backTrack(1, 0);
			if(check == -1) {
				System.out.println("#"+tc+" -1");
			}else {
				System.out.print("#"+tc+" ");
				for(int i=1; i<=soQuocGia; i++) {
					System.out.print(visitColor[i]);
				}
				System.out.println();
			}
		}
	}
}
