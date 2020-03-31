package backtracking;

import java.util.Scanner;

public class DayNhiPhan {
	static int []array = new int[100];
	static int n;
	static void result() {
		for(int i=0; i<n; i++) {
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
	static void backTrack(int i) { // i: index
		for(int j=0; j<=1; j++) {
			array[i] = j;
			if(i==n) {
				result();
			}
			else {
				backTrack(i+1);
			}
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		backTrack(0);
	}

}
