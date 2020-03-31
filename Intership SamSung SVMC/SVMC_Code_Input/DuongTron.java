package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Cho tọa độ tâm đường tròn thứ 1, tâm đường tròn thứ 2 && bán kính đường tròn 1, bán kính đường tròn 2
 * x1,y1,x2,y2,r1,r2
 * Xác định xem 2 đường tròn đó đang ở vị trí tương đối nào:
 * 1. tiếp xúc ngoài
 * 2. tiếp xúc trong
 * 3. trùng nhau
 * 4. chứa trong
 * 5. không giao nhau ở ngoài
 * 6. cắt nhau
 *
 */
public class DuongTron {
	Scanner sc = new Scanner(System.in);
	int t, x1, x2, y1, y2, r1, r2;

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			r1 = sc.nextInt();
			r2 = sc.nextInt();
			// khoảng cách giữa 2 tâm đường tròn
			// chỉ if-else thôi nhưng phải xét theo thứ tự, từ = hết, rồi < all rồi > all
			int d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
			if (x1 == x2 && y1 == y2 && r1 == r2)
				System.out.println(3);
			else if (d == (r1 + r2) * (r1 + r2))
				System.out.println(1);
			else if (d == (r1 - r2) * (r1 - r2))
				System.out.println(2);
			else if (d > (r1 + r2) * (r1 + r2))
				System.out.println(5);
			else if (d > (r1 - r2) * (r1 - r2))
				System.out.println(4);
			else if (d < (r1 + r2) * (r1 + r2))
				System.out.println(6);

		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("DuongTron.txt"));
		DuongTron d = new DuongTron();
		d.solution();
	}

}
