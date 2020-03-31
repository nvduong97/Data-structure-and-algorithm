package practice;

import java.util.Scanner;
/*
 * https://alexishuuuocn.wordpress.com/2019/07/07/liet-ke-tap-con-backtracking/
 */
public class LietKeTapCon {
	static int n;
	static int []a = new int[100];

	static void Show() {
		for (int i = 1; i <= n; i++) {
			if (a[i] != 0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
	}

	static void backTrack(int index) {
		if (index == n + 1) {
			Show();
			return;
		}

		a[index] = 0;
		backTrack(index + 1);
		a[index] = 1;
		backTrack(index + 1);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		backTrack(1);
	}
}
