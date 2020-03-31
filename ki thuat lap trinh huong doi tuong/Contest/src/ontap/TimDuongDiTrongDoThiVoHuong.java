package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TimDuongDiTrongDoThiVoHuong {
	Scanner sc = new Scanner(System.in);
	int t,n,m,q,a,b;
	int map[][];
	void solution() {
		t = sc.nextInt();
		while(t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			map = new int[n+1][n+1];
			for(int i=0; i<m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				map[a][b] = map[b][a] = 1;
			}
			q = sc.nextInt();
			while(q-- > 0) {
				a = sc.nextInt();
				b = sc.nextInt();
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		TimDuongDiTrongDoThiVoHuong timDuongDiTrongDoThiVoHuong = new TimDuongDiTrongDoThiVoHuong();
		timDuongDiTrongDoThiVoHuong.solution();
	}

}
