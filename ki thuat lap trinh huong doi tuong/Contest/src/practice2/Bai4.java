package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai4 { // sap xep noi bot
	Scanner sc = new Scanner(System.in);
	int n;
	int arr[];

	List<Integer> list = new ArrayList<Integer>();

	void solution() {
		n = sc.nextInt();
		arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= n - 1; i++) {
			boolean check = false;
			for (int j = 1; j <= n - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					check = true;
				}
			}
			if (check == false) {
				break;
			} else {
				System.out.print("Buoc " + i + ": ");
				for (int k = 1; k <= n; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		Bai4 bai1 = new Bai4();
		bai1.solution();
	}

}
