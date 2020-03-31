package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// đưa về bài toán xâu nhị phân >= k bit 1 & có k bit 1 liên tiếp
public class Bai14 {
	Scanner sc = new Scanner(System.in);
	int n, k, count = 0;
	int arr[];
	List<String> str = new ArrayList<>();

	String arrayToString(int[] arr) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int i:arr) {
			stringBuilder.append(i == 1 ? "A" : "B");
		}
		return stringBuilder.toString();
	}

	// check k bit 1 liên tiếp
	boolean check() {
		int dem = 0, t = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1) {
				t++;
			} else {
				t = 0;
			}
			if (t > k) {
				return false;
			}
			if (t == k) {
				dem++;
			}
		}
		return (dem == 1);
	}

	void backTrack(int index) {
		if (index == n) {
			if (check() == true) {
				str.add(arrayToString(arr));
				return;
			}
			return;
		}
		for (int i = 0; i <= 1; i++) {
			arr[index] = i;
			backTrack(index + 1);
		}
	}

	void solution() {
		n = sc.nextInt();
		k = sc.nextInt();
		arr = new int[n];
		backTrack(0);
		System.out.println(str.size());
		for (int i = str.size() - 1; i >= 0; i--)
			System.out.println(str.get(i));
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai14.txt"));
		Bai14 bai14 = new Bai14();
		bai14.solution();
	}
}
