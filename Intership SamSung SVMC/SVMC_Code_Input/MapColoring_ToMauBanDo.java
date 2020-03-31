package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
// nếu cảm thấy mình còn gà, còn code kém, còn ko nghĩ được thì hãy nghĩ về câu nói của thầy Sơn: em cứ thức trắng vài đêm là code được hết
// lưu ý chỗ biến vòng lặp for(i=0; i<n; i++) thì cứ thế tất
// còn for(i=1; <=n; i++) thì cứ thế tất ko có lúc thế này, lúc thế kia chả ra đâu vào đâu
public class MapColoring_ToMauBanDo {
	static int testCase, soQuocGia, soDuongBienGioi, x, y, ans, check;
	static int [][]map;
	static int []visitColor;
	static void backTrack(int index, int color) {
		if(visitColor[index] == color) {
			return;
		}
		if(visitColor[index] == 1-color) {
			check = -1;
			return;
		}
		else {
			if(visitColor[index] == -1) {
				visitColor[index] = color;
			}
			for(int i=1; i<=soQuocGia; i++) {
				if(map[index][i] == 1) {
					backTrack(i, 1-color);
				}
			}
		}
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("MapColoring.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		testCase = sc.nextInt();
		for(int tc=1; tc<=testCase; tc++) {
			soQuocGia = sc.nextInt();
			soDuongBienGioi = sc.nextInt();
			map = new int[1000][1000];
			visitColor = new int[1000];
			for(int i=1; i<=soQuocGia; i++) {
				visitColor[i] = -1; 
			}
			for(int i=0; i<soDuongBienGioi; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				map[x][y] = 1;
				map[y][x] = 1;
			}
			check=0;
			backTrack(1, 0);
			if(check == -1) {
				System.out.println("Case #"+tc+" -1");
			}else {
				System.out.print("Case #"+tc+" ");
				for(int i=1; i<=soQuocGia; i++) {
					System.out.print(visitColor[i]);
				}
				System.out.println();
			}
		}
	}

}
