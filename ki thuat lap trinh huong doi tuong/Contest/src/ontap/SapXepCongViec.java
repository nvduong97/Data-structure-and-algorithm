package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SapXepCongViec {
	class CongViec {
		int start;
		int end;

		public CongViec(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

	}

	Scanner sc = new Scanner(System.in);
	int t, n, a, b;
	List<CongViec> list = new ArrayList<SapXepCongViec.CongViec>();

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				list.add(new CongViec(a, b));
				System.out.println(a + " " + b);
			}

			list.sort((o1, o2) -> {
				return o1.getEnd() - o2.getEnd();
			});
			System.out.println("=================================");
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).getStart() + " " + list.get(i).getEnd());
			}
			int count = 1;
			int j = 0;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).getStart() >= list.get(j).getEnd()) {
					count++;
					j = i;
				}
			}
			System.out.println(count);
			list.clear();
		}

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		SapXepCongViec sapXepCongViec = new SapXepCongViec();
		sapXepCongViec.solution();
	}

}
