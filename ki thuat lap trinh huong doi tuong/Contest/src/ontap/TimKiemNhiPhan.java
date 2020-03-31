package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TimKiemNhiPhan {
	Scanner sc = new Scanner(System.in);
	int n, a[], k;

	void solution() {
		n = sc.nextInt();
		k = sc.nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int left = 0;
		int right = n - 1;
		boolean check = false;
		while (left < right) {
			int mid = (left + right) / 2;
			if (a[mid] == k) {
				check = true;
				System.out.println("YES");
				break;
			} else if (a[mid] < k) {
				left = mid + 1;
			} else if (a[mid] > k) {
				right = mid - 1;
			}
		}
		if(check == false) {
			System.out.println("NO");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		TimKiemNhiPhan timKiemNhiPhan = new TimKiemNhiPhan();
		timKiemNhiPhan.solution();
	}

}
