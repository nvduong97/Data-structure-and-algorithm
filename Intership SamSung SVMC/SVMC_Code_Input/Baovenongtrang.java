package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * https://alexishuuuocn.wordpress.com/2019/07/18/bao-ve-nong-trang/
 * https://vn.spoj.com/problems/NKGUARD/
*Bài bảo vệ nông trang này làm trên spoj thì AC
*làm trên server công ty thì fail. Khi chạy 3 testcase mẫu thì ko sao, chạy sang 50 tc thì chết luôn từ lúc đọc data

*/

/* khi mà testcase có đỉnh là 4 thì các đỉnh xung quanh nhỏ hơn thì mặc đình check=1 ko thay đổi nên nó là đỉnh đổi
* khi mà testcase có đỉnh kề nhau liên tiếp 2 2 thì nó thuộc 1 đỉnh đồi, Loang tiếp các đỉnh xung quanh nhỏ hơn thì ko phải xét nữa, check vẫn = 1 nên vẫn là đỉnh đồi
* đỉnh kề cao hơn thì ko thuộc 1 đỉnh đồi nữa
* còn đỉnh đồi nhỏ hơn thì mặc định nó là đỉnh rồi
*/
public class Baovenongtrang {
	static int t, n, m, check;
	static int[][] data;
	static int[][] visit;
	static int[] dx = { -1, 0, 0, 1, -1, 1, -1, 1 };
	static int[] dy = { 0, -1, 1, 0, -1, -1, 1, 1 };

	static void LoangBFS(int startX, int startY) {
		visit[startX][startY] = 1;
		for (int i = 0; i < 8; i++) {
			int x = startX + dx[i];
			int y = startY + dy[i];
			if (x >= 0 && x < n && y >= 0 && y < m) {
				/*
				 * Tại mỗi thời điểm mà tồn tại 1 điểm kề có giá trị lớn hơn thì điểm đó không
				 * phải là đỉnh đồi
				 */
				if (check == 1 && data[x][y] > data[startX][startY]) {
					check = 0;
				}
				/*
				 * Duyệt các điểm có cùng độ cao mà chưa được duyệt vì các điểm đó sẽ cùng thuộc
				 * 1 đỉnh đồi testcase 2 2 cạnh nhau cùng thuộc 1 đỉnh đồi
				 */
				if (data[x][y] == data[startX][startY] && visit[x][y] == 0) {
					LoangBFS(x, y);
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("Baovenongtrang.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			// m = Integer.parseInt(sc.nextLine());
			data = new int[n + 10][m + 10];
			visit = new int[n + 10][m + 10];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (visit[i][j] == 0) {
						check = 1; // check: danh dau dinh danh xet co phai dinh doi hay khong
						LoangBFS(i, j);
						if (check == 1) {
							count++;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + count);

		}
	}

}
