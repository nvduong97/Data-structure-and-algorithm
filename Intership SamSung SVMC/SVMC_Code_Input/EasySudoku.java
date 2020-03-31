package practice;

import java.io.FileInputStream;
import java.util.Scanner;

/*
 * EASUDOKU - EASY SUDOKU
 * https://www.spoj.com/problems/EASUDOKU/
9/10/2016
 COMMENTS

Đề bài yêu cầu xác định ma trận sudoku dựa trên ma trận đầu vào 9x9. Với giá trị 0 là giá trị cần phải điền số phù hợp sao cho mỗi hàng, mỗi cột, mỗi hình vuông con 3x3 chỉ tồn tại duy nhất 1 số từ 1 đến 9. Nếu k thể tìm được ma trận phù hợp với đề bài in ra "No solution".
Sample Input

Giải thuật:
Tại một ô tọa độ i, j sẽ có 2 trường hợp.
- Đã được điền (có giá trị khác 0) thì hãy chuyển sang ô tiếp theo i, j+1 hoặc i+1, 0 (trường hợp xuống dòng).
- Chưa được điền thử giá trị k (trong khoảng từ 1 - 9) kiểm tra k xem đã tồn tại trong hàng, cột, hoặc hình vuông 3x3 chưa nếu chưa thì set giá trị tại ô i,j là k và chuyển đến ô tiếp theo i, j+1 hoặc i+1, 0 (trường hợp xuống dòng).
Nếu i, j có thể đi qua ô tọa độ 8,8 (vì ma trận kích thước 9x9) thì tồn tại solution và in ra ma trận.
Sử dụng 1 cờ flag để thoát khỏi hàm backtrack khi đã tìm được solution.
 */
public class EasySudoku {
	Scanner sc = new Scanner(System.in);
	int t;
	boolean check;
	int map[][];

	void init() {
		check = false;
		map = new int[10][10];
	}

	boolean checkHangCot(int x, int y, int value) {
		for (int i = 0; i < 9; i++) {
			if (value == map[x][i] || value == map[i][y]) {
				return true;
			}
		}
		return false;
	}

	boolean checkMaTran3x3(int x, int y, int value) {
		int startX = x / 3;
		int startY = y / 3;
		int i = startX * 3;
		int j = startY * 3;
		for (int h = i; h < i + 3; h++) {
			for (int k = j; k < j + 3; k++) {
				if (value == map[h][k])
					return true;
			}
		}
		return false;
	}

	void backTrack(int x, int y) {
		if (x >= 9) {
			check = true;
			return;
		}
		if (map[x][y] != 0) {
			if (y < 8) {
				backTrack(x, y + 1);
			} else {
				backTrack(x + 1, 0);
			}
		}
		if (map[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (checkHangCot(x, y, i) == false && checkMaTran3x3(x, y, i) == false) {
					map[x][y] = i;
					if (y < 8) {
						backTrack(x, y + 1);
					} else {
						backTrack(x + 1, 0);
					}
					if (check == true)
						return;
					map[x][y] = 0;
				}
			}
		}
	}

	void solutiton() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			init();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			backTrack(0, 0);
			if (check == true) {
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("No solution");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("EasySudoku.txt"));
		EasySudoku e = new EasySudoku();
		e.solutiton();
	}

}