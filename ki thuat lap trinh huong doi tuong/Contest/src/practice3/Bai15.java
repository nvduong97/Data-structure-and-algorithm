package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Tree: có n đỉnh, (n-1) cạnh. Cây là 1 đồ thị liên thông, không có chu trình
 * Cho (n-1) cạnh, ta kiểm tra lại xem có đúng có n đỉnh hay không
 * 
 */
public class Bai15 { // kiem tra do thi co phai cong khong
	Scanner sc = new Scanner(System.in);
	int t, n, a, b;

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			List<Integer> list = new ArrayList<>();
			for (int i = 1; i <= n - 1; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				if (!list.contains(a)) {
					list.add(a);
				}
				if (!list.contains(b)) {
					list.add(b);
				}
			}
			if (list.size() == n) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai15 bai15 = new Bai15();
		bai15.solution();

	}
}
