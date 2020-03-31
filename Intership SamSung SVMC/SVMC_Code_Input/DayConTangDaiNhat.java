package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * https://vn.spoj.com/problems/LIQ/
 * https://alexishuuuocn.wordpress.com/2019/07/07/liq-day-con-tang-dai-nhat-ban-de/
 * 
 */
public class DayConTangDaiNhat {
	static int n;
	static int []arr;
	static int []f;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("DayConTangDaiNhat.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1];
		f = new int[n+1];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			f[i] = 1;
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i] && f[j]+1 > f[i]) f[i]=f[j]+1;
			}
		}
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				if(f[i] > f[j]) {
					int temp = f[i]; f[i]=f[j]; f[j]=temp;
				}
				
			}
		}
//		for(int i=0; i<n; i++) {
//			System.out.print(f[i]+" ");
//		}
		System.out.println(f[n-1]);
	}

}
