package practice1;

import java.util.Scanner;

public class B3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int k = 1; k <= n; k++) {
			int t = sc.nextInt();
			int A[] = new int[t];
			int L[] = new int[t];
			for (int i = 0; i < t; i++) {
				A[i] = sc.nextInt();
				L[i] = 1;
			}
			int max = 0;
			for (int i = 1; i < t; i++) {
				if (A[i] > A[i - 1]) {
					L[i] = L[i - 1] + 1;
					max = L[i] > max ? L[i] : max;
				} else
					L[i] = 1;
			}
			System.out.println("Test " + k + ":");
			System.out.println(max);
			for (int i = 0; i < t; i++) {
				if (L[i] == max) {
					for (int j = i + 1 - max; j <= i; j++) {
						System.out.print(A[j] + " ");
					}
					System.out.println("");
				}
			}
		}
	}
}
