package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* y tuong: sinh nhi phan
 * neu visit[]=1 thi thuc hien arr[i] len 1
 * https://alexishuuuocn.wordpress.com/2019/07/18/little-elephants/
 */
public class LittleElephants {
	static int t, n, k, m;
	static int[] arr;
	static int[] visit;
	static int ans = 0;

	static void sinhNhiPhan(int index) {
		if (index == n) { // sinh nhi phan toi con voi thu n
			int dem = 0;
			/*
			 * dem vi tri so 1, vi moi con duoc cong len 1 lan nen tai vi tri visit[]=1 thuc
			 * hien cong gia tri arr[i] len 1
			 */
			for (int i = 0; i < n; i++) {
				if (visit[i] == 1) {
					arr[i]++;
					dem++;
				}
			}
			int check = 1;
			// tim gia tri max trong k con voi
			for (int i = 0; i <= n - k; i++) {
				int temp = 0;
				for (int j = i; j < i + k; j++) {
					if (arr[j] >= temp) {
						temp = arr[j];
					}
				}
				int countVoiMax = 0;
				for (int j = i; j < i + k; j++) {
					if (arr[j] == temp) {
						countVoiMax++;
					}
				}
				if (countVoiMax >= m) {
					check = 0;
				}
			}
			if (check == 1) {
				if (ans >= dem) {
					ans = dem;
				}
			}
			// vua thuc hien xong cong len 1
			// thuc hien xong tru di 1
			for (int i = 0; i < n; i++) {
				if (visit[i] == 1) {
					arr[i]--;
				}
			}
			return;
		}
		visit[index] = 0;
		sinhNhiPhan(index + 1);
		visit[index] = 1;
		sinhNhiPhan(index + 1);
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("LittleElephants.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			m = sc.nextInt();
			arr = new int[n + 10];
			visit = new int[100];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			ans = 10000;
			sinhNhiPhan(0);
			if (ans == 10000) {
				ans = -1;
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
