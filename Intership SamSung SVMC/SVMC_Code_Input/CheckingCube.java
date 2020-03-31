package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* https://alexishuuuocn.wordpress.com/2019/07/18/checking-cube/
 * tìm tất cả những số lập phương không lớn hơn N.
 * Sau đó kiểm tra tất cả các trường hợp có thể.
 * Quay lui có điều kiện
 */
public class CheckingCube {
	static int t, n, lengh, ans;
	static int[] arr;

	/*
	 * num: số phần tử đã chọn sum: tổng các phần tử đã chọn savePosition: lưu vị
	 * trí của số đã chọn lúc trước
	 */
	static void backTrack(int num, int sum, int savePositionLast) {
		// đề yêu cầu là tổng của tối đa 5 khối lập phương nên chỉ được chọn 5
		// lần
		if (num == 5) {
			if (sum == n) {
				ans++;
			}
			return; // nếu num==5 mà sum!=n thì return ngay, đáp án là 0
		}
		// duyệt các mảng trong số lập phương <=n để thử các số
		for (int i = 0; i < lengh; i++) {
			if (i >= savePositionLast) {
				backTrack(num + 1, sum + arr[i], i);
			}
		}
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("CheckingCube.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			// tìm ra tất cả các số lập phương nhỏ hơn n và lưu vào 1 mảng
			lengh = 0;
			ans = 0;
			arr = new int[n + 1];
			while (true) {
				int temp = lengh * lengh * lengh;
				if (temp > n) {
					break;
				} else {
					arr[lengh++] = temp;
				}
			}
			// backtracking để kiểm tra tất cả các trường hợp xảy ra
			backTrack(0, 0, -1);
			System.out.println("#" + tc + " " + ans);
		}
	}

}
