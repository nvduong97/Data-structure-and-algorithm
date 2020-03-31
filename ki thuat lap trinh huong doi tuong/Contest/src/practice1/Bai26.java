package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * a.7+ b.4 = n (1)
vì là số nhỏ nhất nên càng ít số càng tốt --> ưu tiên số 7 --> a max, b min --> mà a max cũng chỉ có thể = n /7 nếu n chia hết cho 7, b min = 0 khi n chia hết cho 7, nếu chưa thỏa mãn (1) thì giảm 1 số 7 và xem lại xem thỏa mãn thì có thể dừng --> tìm được số lượng số 7,4 để số chữ số nhỏ nhất (nếu không có a,b thì -1)
vì là nhỏ nhất --> in hết số 4 trước rồi in số 7

Ae tham khảo để submit lên thì xóa comment đi, để comment submit lên bị compiler error
 */
public class Bai26 {
	Scanner sc = new Scanner(System.in);
	int t, n;
	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			boolean check = false;
			n = sc.nextInt();
			int first = 0, sencond = 0;
			for (int i = n / 7; i >= 0; i--) {
				if ((n - 7 * i) % 4 == 0) {
					sencond = i;
					first = (n - 7 * i)/4;
					check = true;
					break;
				}
			}
			
			if (check == false) {
				System.out.println(-1);
			} else {
				for (int i = 0; i < first; i++) {
					System.out.print(4);
				}
				for (int i = 0; i < sencond; i++) {
					System.out.print(7);
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai26.txt"));
		Bai26 bai26 = new Bai26();
		bai26.solution();
	}

}
