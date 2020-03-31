package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Trên bàn cờ vua kích thước nxn đặt n quân hậu sao cho chúng ko ăn được nhau
 * đếm số cách đặt, in ra cấu hình đặt sao cho n quân trong đó ko có 2 quân nào ăn được nhau
 * biết rằng quân hậu có thể đi ngang, dọc, chéo
 */
public class BaiToanNQuanHau {
	Scanner sc = new Scanner(System.in);
	int n, dem;
	int map[][];
	boolean visit[];
	void result() {
		dem++;
	}
	void init() {
		dem = 0;
	}
	void Try(int i) {
		
	}
	void solution() {
		n = sc.nextInt();
		init();
		
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("BaiToanNQuanHau.txt"));
		BaiToanNQuanHau k = new BaiToanNQuanHau();
		k.solution();
	}

}
