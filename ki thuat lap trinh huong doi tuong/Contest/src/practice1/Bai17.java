package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class Bai17 {
	Scanner sc = new Scanner(System.in);
	int n, k;
	int arr[][];
	Vector<Integer> x = new Vector<>();
	Vector<Integer> v = new Vector<>();
	boolean checkSum() {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i][x.elementAt(i)];
		}
		return (sum == k);
	}

	void backTrackHoanVi(int index) {
		
	}

	void solution() {
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		backTrackHoanVi(1);
		System.out.println(v.size());
		for(int i=0; i<v.size(); i++) {
			for(int j=0; j<n; j++) {
				
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Bai17.txt"));
		Bai17 bai17 = new Bai17();
		bai17.solution();
	}

}
