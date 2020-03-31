package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DayConTangDaiNhat {
	Scanner sc = new Scanner(System.in);
	int n, a[], l[];

	void solution() {
		n = sc.nextInt();
		a = new int[n];
		l = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			l[i] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && l[i]+1 > l[j]) {
					l[i] = l[j]+1;
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			System.out.print(l[i] + " ");
//		}
		Arrays.sort(l);
//		System.out.println();
//		for (int i = 0; i < n; i++) {
//			System.out.print(l[i] + " ");
//		}
//		System.out.println();
		System.out.println(l[n-1]);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		DayConTangDaiNhat dayConTangDaiNhat = new DayConTangDaiNhat();
		dayConTangDaiNhat.solution();
	}

}
