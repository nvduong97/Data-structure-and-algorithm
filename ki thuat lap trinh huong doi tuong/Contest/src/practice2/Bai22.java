package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai22 {
	Scanner sc = new Scanner(System.in);
	int t,n;
	int a[];
	void solution() {
		t = sc.nextInt();
		while(t-- > 0) {
			n = sc.nextInt();
			a = new int[n];
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai22 bai22 = new Bai22();
		bai22.solution();
	}
}
