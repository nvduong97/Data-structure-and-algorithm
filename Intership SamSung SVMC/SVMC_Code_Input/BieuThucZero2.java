package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream.GetField;
import java.util.Scanner;
/*
 * https://alexishuuuocn.wordpress.com/2019/07/18/bieu-thuc-zero/
 * hướng dẫn: http://codepascalvn.blogspot.com/2017/03/ly-thuyet-ve-e-quy.html
 * http://dongsvmc.blogspot.com/2017/06/bieu-thuc-zero-thuat-toan-quay-lui.html
 * điền '+' or '-' or không điền gì
 */

import java.io.FileInputStream;
import java.util.Scanner;

public class BieuThucZero2 {
	static int t, n, count, tailNumber, tailDau;
	static int[] arrayNumber;
	static int[] stackNumber;
	static int[] stackDau;

	static void sinhHoanVi(int k) {
		if (k == n) {
			int sum = 0;
			stackNumber = new int[n];
			stackDau = new int[n];
			tailDau = -1;
			tailNumber = -1;

			// dấu 0 - "space", 1 - '+', 2 - '-'
			// cho số với dấu đầu tiên vào stack
			// n = 7, tập số sẽ từ 1,2,3,4,5,6,7
			// không có số 0
			stackDau[++tailDau] = arrayNumber[1];
			stackNumber[++tailNumber] = 1;
			for (int i = 2; i <= n; i++) {
				// push cac tiep theo vao stack
				stackNumber[++tailNumber] = i;
				if (stackDau[tailDau] == 0) {
					int a = stackNumber[tailNumber--];
					int b = stackNumber[tailNumber--];
					stackNumber[++tailNumber] = b * 10 + a;
					tailDau--;
				}
				stackDau[++tailDau] = arrayNumber[i];

			}
			sum = stackNumber[0];
			for (int i = 0; i < tailDau; i++) {
				if (stackDau[i] == 1) {
					sum += stackNumber[i + 1];
				}
				if (stackDau[i] == 2) {
					sum -= stackNumber[i + 1];
				}
			}
			if (sum == 0) {
				count++;
			}
			// sum != 0
			return;
		} else {
			// 0 la khong dau, 1 la dau +, 2 la dau -
			for (int dau = 0; dau < 3; dau++) {
				arrayNumber[k] = dau;
				sinhHoanVi(k + 1);
			}

		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BieuThucZero.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			arrayNumber = new int[n + 1];
			count = 0;
			sinhHoanVi(1);
			System.out.println("#" + tc + " " + count);
		}
	}
}
