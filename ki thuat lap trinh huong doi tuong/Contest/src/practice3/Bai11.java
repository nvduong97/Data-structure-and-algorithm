package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// danh sach ke => ma tran ke => danh sach canh
public class Bai11 { // chuyen tu danh sach ke sang danh sach canh
	Scanner sc = new Scanner(System.in);
	int n;// n dinh
	int map[][];
	String s, str[];

	void solution() {
		n = sc.nextInt();
		sc.nextLine();
		map = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			s = sc.nextLine();
			str = s.split(" ");
			for (int j = 0; j < str.length; j++) {
				int chiSo = Integer.parseInt(str[j]);
				map[i][chiSo] = map[chiSo][i] = 1;
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(map[i][j] == 1) {
					System.out.println(i+" "+j);
					map[i][j] = map[j][i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai11 bai10 = new Bai11();
		bai10.solution();
	}

}
