package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;

public class Bai26 {
	Scanner sc = new Scanner(System.in);
	int n;
	int map[][];
	String s;
	int a, b, c, d;
	boolean visitX[];
	boolean visitY[];
	void BFS(int x, int y) {
		
	}
	void solution() {
		n = sc.nextInt();
		sc.nextLine();
		map = new int[n + 1][n + 1];
		visitX = new boolean[n];
		visitY = new boolean[n];
		for (int i = 0; i < n; i++) {
			s = sc.nextLine();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == 'X') {
					map[i][j] = 1;
				}
			}
		}
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai26 bai26 = new Bai26();
		bai26.solution();
	}

}
