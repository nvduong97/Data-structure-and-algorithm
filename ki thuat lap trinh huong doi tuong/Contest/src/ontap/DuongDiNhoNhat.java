package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DuongDiNhoNhat {
	Scanner sc = new Scanner(System.in);
	int t, n, m;
	int map[][], cost[][];

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n][m];
			cost = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			cost[0][0] = map[0][0];
			for (int i = 1; i < n; i++) {
				cost[0][i] = cost[0][i - 1] + map[0][i];
			}
			for (int i = 1; i < n; i++) {
				cost[i][0] = cost[i - 1][0] + map[i][0];
			}
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					cost[i][j] = Math.min(cost[i - 1][j - 1], Math.min(cost[i - 1][j], cost[i][j - 1])) + map[i][j];
				}
			}
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < n; j++) {
//					System.out.print(cost[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.println(cost[n-1][m-1]);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		DuongDiNhoNhat duongDiNhoNhat = new DuongDiNhoNhat();
		duongDiNhoNhat.solution();
	}

}
