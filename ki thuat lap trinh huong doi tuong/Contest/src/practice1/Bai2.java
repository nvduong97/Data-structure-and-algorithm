package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai2 {
	int testCase, n;
	boolean check;
	int arr[] = new int[200];
	Scanner sc = new Scanner(System.in);

	void solution() {
		testCase = sc.nextInt();
		while (testCase-- > 0) {
			check = true;
			n = sc.nextInt();
			for (int i = 1; i <= n; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 1; i <= n/2; i++) {
				if(arr[i] != arr[n-i+1]) {
					check = false; 
					break;
				}
			}
			if(check == true) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai2.txt"));
		Bai2 b = new Bai2();
		b.solution();
	}
}
