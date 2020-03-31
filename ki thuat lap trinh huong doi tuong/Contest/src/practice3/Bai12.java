package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Bai12 { // chuyen tu ma tran ke sang danh sach ke
	Scanner sc = new Scanner(System.in);
	int n;
	int a[][];
	void solution() {
		n = sc.nextInt();
		a = new int[n+1][n+1];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(a[i][j]==1) {
					System.out.print((j+1)+" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai12 bai12 = new Bai12();
		bai12.solution();
	}

}
