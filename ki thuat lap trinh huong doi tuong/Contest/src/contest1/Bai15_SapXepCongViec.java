package contest1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// máy trên trường hôm đấy làm là lỗi Java 7, còn máy của mình là Java 8
public class Bai15_SapXepCongViec {
	class CongViec {
		int start;
		int end;

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

		public CongViec(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

	}

	Scanner sc = new Scanner(System.in);
	int t, n;
	int a, b;
	ArrayList<CongViec> list = new ArrayList<>();

	void solution() {
		t = sc.nextInt();
		 //System.out.println(t);
		while (t-- > 0) {
			n = sc.nextInt();
			// System.out.println(n);
			for (int i = 0; i < n; i++) {
//				a = sc.nextInt();
//				b = sc.nextInt();
//				list.add(new CongViec(a, b));
				// System.out.println(a + " " + b);
				list.add(new CongViec(sc.nextInt(), sc.nextInt()));
			}
//			for(int i=0; i<list.size(); i++) {
//				System.out.println(list.get(i).getStart()+" "+list.get(i).getEnd());
//			}
			list.sort((o1, o2) -> {
				return o1.end - o2.end;
			});
//			System.out.println();
//			for (int i = 0; i < list.size(); i++) {
//				System.out.println(list.get(i).getStart() + " " + list.get(i).getEnd());
//			}
			int count = 1;
			int j = 0;
			for (int i = 1; i < list.size(); i++) {
				if (list.get(i).getStart() >= list.get(j).getEnd()) {
					j++;
					count++;
				}
			}
			System.out.println(count);
			list.clear();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai25.txt"));
		Bai15_SapXepCongViec sapXepCongViec = new Bai15_SapXepCongViec();
		sapXepCongViec.solution();
	}

}
