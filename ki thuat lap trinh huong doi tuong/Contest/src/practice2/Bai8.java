package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
// bai nay dung 2 mang thi ac, dung 1 mang & tinh min thi no wrong answer
public class Bai8 { // BRT
	Scanner sc = new Scanner(System.in);
	int t, n;
	int a[], b[];
	int min = 99999999;

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			a = new int[n];
			b = new int[n-1];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			Arrays.sort(a);
			for (int i = 0; i < n - 1; i++) {
				b[i]= a[i + 1] - a[i];
			}
			Arrays.sort(b);
			
			int count=0;
			for(int i=0; i<=n-2; i++) {
				if(b[i] == b[0]) count++;
				else if(b[i] > b[0]) break;
			}
			System.out.println(b[0]+" "+count);
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai8 bai9 = new Bai8();
		bai9.solution();
	}

}
