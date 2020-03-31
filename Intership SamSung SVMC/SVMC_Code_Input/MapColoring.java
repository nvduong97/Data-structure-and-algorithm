package backtracking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MapColoring {
	static int t, n, e, tc, check, x, y;
	static int [][]map;
	static int[] color; // color[] ở đây có vai trò vừa là tô màu, vừa là visit luôn
	// lưu ý: khi viết code tránh khai báo các biến toàn cục trong vòng lặp như biến i, j chả hạn
	// trong for(i=1; i<=n; i++) => ko nên
	// mà nên viết là for(int i=1; i<=n; i++)
	static void backTrack(int dinh, int mau) {
		// dieu kien dung
		if(color[dinh] == mau) { // nếu đỉnh đã tô màu thì ko tô màu nữa & return
			return;
		}
		if(color[dinh] == 1-mau) { // nếu đỉnh đã tô màu rồi mà lại muốn tô tiếp thì dừng => vì trường hợp này sẽ in ra -1
			check = -1;
			return;
		}
		if(color[dinh] == -1) { // nếu đỉnh chưa tô màu thì tô màu cho đỉnh
			color[dinh] = mau;
			
		}
		for(int i=1; i<=n; i++){ // chỗ này cần xét điều kiện biên kỹ: i <= n 
			if(map[dinh][i] == 1) {
				backTrack(i, 1-mau);
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
		t = sc.nextInt();
		for (tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			e = sc.nextInt();
			color = new int[n+1];
			map = new int[n + 1][n + 1];
			for(int i=1; i<=n; i++) {
				color[i] = -1; // chưa đỉnh nào được tô màu
			}
			for (int i = 1; i <= e; i++) {
				x = sc.nextInt();
				y = sc.nextInt();
				map[x][y] = 1;
				map[y][x] = 1;
			}
//			for(int i=1; i<=n; i++){
//				for(int j=1; j<=n; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
			check = 0;
			backTrack(1, 0); // bắt đầu từ đỉnh 1 và tô màu 0 cho nó (0 - màu đỏ, 1 - màu xanh)
			if (check == -1) { // ko tô màu được thì in ra -1
				System.out.println("#" + tc + " -1");
			} else {
				System.out.print("#" + tc + " ");
				for (int i = 1; i <= n; i++) {
					System.out.print(color[i]);
				}
				System.out.println();
			}
		}
	}

}
