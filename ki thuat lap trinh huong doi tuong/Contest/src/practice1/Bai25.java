package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
 *  SẮP XẾP CÔNG VIỆC
 */
public class Bai25 {
	Scanner sc = new Scanner(System.in);
	int t, n;
	List<CongViec> list = new ArrayList<>();

	class CongViec {
		int batDau;
		int ketThuc;

		public CongViec(int batDau, int ketThuc) {
			super();
			this.batDau = batDau;
			this.ketThuc = ketThuc;
		}

		public int getBatDau() {
			return batDau;
		}

		public void setBatDau(int batDau) {
			this.batDau = batDau;
		}

		public int getKetThuc() {
			return ketThuc;
		}

		public void setKetThuc(int ketThuc) {
			this.ketThuc = ketThuc;
		}

	}

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				list.add(new CongViec(sc.nextInt(), sc.nextInt()));
			}
			list.sort((object1, object2) -> {
				return object1.ketThuc - object2.ketThuc;
			});
			int j = 0;
			int count = 1;
			for (int i = 1; i < n; i++) {
				if (list.get(i).batDau >= list.get(j).ketThuc) {
					j = i;
					count++;
				}
			}
			System.out.println(count);
			list.clear(); // xong 1 test case reset lại list
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai25.txt"));
		Bai25 bai25 = new Bai25();
		bai25.solution();
	}

}
