package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// Bài này ko dùng được ma trận kề mà phải chuyển sang danh sách kế
public class Bai22 { // duong di DFS
	Scanner sc = new Scanner(System.in);
	int t, n, m, start, end, a, b;
	List<Integer>[] list;
	Stack<Integer> stack;
	int duongDi[];

	void DFS(int Start, int End) {
		stack.add(Start);
		duongDi[Start] = Start;
		while (!stack.isEmpty()) {
			int top = stack.peek();
			stack.pop();
			if (top == End) {
				break;
			}
			for (int i = 0; i < list[top].size(); i++) {
				int next = list[top].get(i);
				if (duongDi[next] == 0) {
					duongDi[next] = top;
					stack.push(top);
					stack.push(next);
					break;
				}
			}
		}
		if (duongDi[End] == 0) {
			System.out.println(-1);
			return;
		}
		int count = 0;
		while (End != Start) {
			count++;
			End = duongDi[End];
		}
		System.out.println(count);
	}

	void solution() {
		t = sc.nextInt();
		while (t-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			start = sc.nextInt();
			end = sc.nextInt();
			list = new List[n + 1];
			stack = new Stack<>();
			duongDi = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 1; i <= m; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				list[a].add(b);
				list[b].add(a);
			}
			DFS(start, end);

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai22 bai22 = new Bai22();
		bai22.solution();
	}

}
