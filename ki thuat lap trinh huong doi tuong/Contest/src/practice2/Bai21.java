package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai21 { // phan tu ben phai dau tien lon hon
	Scanner sc = new Scanner(System.in);
	int t, n;
	List<Integer> list = new ArrayList<>();

	void solution() {
		t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			for (int i = 0; i < list.size() - 1; i++) {
				boolean check = false;
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i) < list.get(j)) {
						System.out.print(list.get(j)+" ");
						check = true;
						break;
					}
				}
				if (check == false) {
					System.out.print("-1 ");
				}
			}
			System.out.print("-1");
			System.out.println();
			list.clear();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai21 bai21 = new Bai21();
		bai21.solution();
	}

}
