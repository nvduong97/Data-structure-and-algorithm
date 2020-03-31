package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
// sum all elements in array
// sum/2 with sum of size/i

public class ArrayGame {
	static Scanner sc;
	static int n;
	static long[] sumFromStart;
	static long[] sumFromEnd;
	static long[] data;
	static long m_count;

	static void readData() {
		n = sc.nextInt();
		data = new long[n + 2];
		for (int i = 1; i <= n; i++) {
			data[i] = sc.nextLong();
		}
//        for (int i = 1; i <= n; i++) {
//            System.out.print(data[i]+" ");
//        }
//        System.out.println();
		sumFromStart = new long[n + 2];
		sumFromEnd = new long[n + 2];

		for (int i = 1; i <= n; i++) {
			sumFromStart[i] = sumFromStart[i - 1] + data[i];
		}

		// với trường hơp n=7 có 0 0 0 0 0 0 0 => có 6 trường hợp chia
		if (sumFromStart[n] == 0) {
			System.out.println(n - 1);
		} else {
			m_count = 0;
			backTrack(1, n, 0);
			System.out.println(m_count);
		}

	}

	// đúng cái ý tưởng của mình lúc nãy mà ko biết code
	// giống quiksort
	static void backTrack(int start, int end, long count) {
		if (start < end) {
			for (int i = start; i <= end; i++) {
				long lstart = sumFromStart[i] - sumFromStart[start - 1];
				long lend = sumFromStart[end] - sumFromStart[i];
				if (lstart == lend) {
					count++;
					if (count > m_count) {
						m_count = count;
					}
					backTrack(start, i, count);
					backTrack(i + 1, end, count);
					return;
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("ArrayGame.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			readData();
		}
	}

}
