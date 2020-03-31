package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;
/*
 * link: https://alexishuuuocn.wordpress.com/2019/07/07/di-chuyen-bo/
 * bài này có 2 cách:
 * Cách 1: sinh nhị phân rồi xét các trường hợp có thể max nhất của k trong n con bò
 * ở đây từ bài toán sinh nhị phân quy về bài toán tổ hợp C(k,n)
 * Cách 2: quy hoạch động
 */
public class DiChuyenBo {
	static int t, n, m, answer;
	static int []a;
	static int []visit;
	static void backTrack(int num) {
		// nên nhớ điều kiện dừng thường sẽ là Try(0) sẽ dừng ở n-1 or n
		// còn Try(1) sẽ dừng ở n+1 
		if(num == n) {
			int khoiLuong = 0;
			for(int i=0; i<n; i++) {
				if(visit[i]!=0) {
					khoiLuong+=a[i];
					
				}
			}
			if(khoiLuong <= m) {
				if(khoiLuong > answer) {
					answer = khoiLuong;
				}
			}
			if(khoiLuong > m) return;
		}else {
			visit[num] = 0;
			backTrack(num+1);
			visit[num]=1;
			backTrack(num+1);
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("DiChuyenBo.txt"));
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			m = sc.nextInt();
			n = sc.nextInt();
			a = new int[n+1];
			visit = new int[n+1];
			for(int i=0; i<n; i++) {
				a[i] = sc.nextInt();
			}
			answer = 0;
			backTrack(0);
			System.out.println("#"+tc+" "+answer);
		}
		
	}

}
