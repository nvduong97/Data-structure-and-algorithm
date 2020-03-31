package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bai23 { // cau truc du lieu hang doi
	Scanner sc = new Scanner(System.in);
	int t, n;
	int choise, k;
	int a[];
	LinkedList<Integer> queue = new LinkedList<Integer>();
	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			while (n-- > 0) {
				choise = sc.nextInt();
				if (choise == 1) {
					System.out.println(queue.size());
				} else if (choise == 2) {
					if (queue.isEmpty()) {
						System.out.println("YES");
					} else {
						System.out.println("NO");
					}
				} else if (choise == 3) {
					k = sc.nextInt();
					queue.add(k);
				} else if (choise == 4) {
					while (!queue.isEmpty()) {
						queue.remove();
					}
				} else if (choise == 5) {
					if (!queue.isEmpty()) {
						System.out.println(queue.peekFirst());
					} else {
						System.out.println(-1);
					}
				} else if (choise == 6) {
					if (!queue.isEmpty()) {
						System.out.println(queue.peekLast());
					} else {
						System.out.println(-1);
					}
				}
			}
			queue.clear();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai23 bai23 = new Bai23();
		bai23.solution();
	}
}
