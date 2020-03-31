package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * https://alexishuuuocn.wordpress.com/2019/07/18/bieu-thuc-zero/
 */
public class BieuThucZero {
	static int T;
	static int N;
	static int sum;
	static int[] A;
	static int[] Luu;
	static int temp;
	static int count;

// 1 -> + . 2 -> - . 3 -> ""
	static void TinhTong() {
		sum = 1;
		temp = 0;
		for (int i = 2; i <= N + 1; i++) {
			if (A[i] == 1) {
				sum = sum + i;
			} else if (A[i] == 2) {
				sum = sum - i;
			} else if (A[i] == 3) {
				if (i == 2) {
					sum = 0;
					temp = (i - 1) * 10 + i;
					sum = sum + temp;
				} else {
					if (A[i - 1] == 2) {
						temp = (i - 1) * 10 + i;
						sum = sum - temp + (i - 1);
					} else if (A[i - 1] == 1) {
						temp = (i - 1) * 10 + i;
						sum = sum + temp - (i - 1);
					} else if (A[i - 1] == 3) {
						sum = sum - temp;
						temp = temp * 10 + i;
						sum = sum + temp;
					}

				}

			}

		}
	}

	static void SinhTamPhan(int x) {
		if (x == N + 1) {

			TinhTong();
			if (sum == 0) {
//                for (int i = 2; i <= N + 1; i++) {
//                    System.out.print(A[i] + " ");
//                }
//                System.out.println();
				count++;
			}
			return;
		}
		for (int i = 1; i <= 3; i++) {
			A[x] = i;
			SinhTamPhan(x + 1);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("BieuThucZero.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			count = 0;
			N = sc.nextInt();
			A = new int[N + 2];
			// Luu = new int[N + 1];
			SinhTamPhan(2);
			System.out.println("#" + tc + " " + count);

		}

	}

}
