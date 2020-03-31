package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* bài này visit cột, đường chéo xuôi, đường chéo ngược. Ko cần thiết phải visit hàng làm gì cả, vì nó đặt theo thứ tự từ 1 tới n rồi
Vừa xong có khi test biên không kỹ (để duongCheoXuoi[2*n-1] thành ra bị runtime error
*/
public class Bai18 {
	int n, count;
	int hang[], cot[], duongCheoXuoi[], duongCheoNguoc[];
	Scanner sc = new Scanner(System.in);

	void init() {
		n = sc.nextInt();
		hang = new int[n + 1];
		cot = new int[n + 1];
		duongCheoXuoi = new int[2 * n];
		duongCheoNguoc = new int[2 * n];

	}

	void result() {
		count++;
//		for (int i = 1; i <= n; i++) {
//			System.out.print(hang[i] + " ");
//		}
//		System.out.println();
	}

	void backTrack(int i) {
		if (i == n + 1) {
			result();
			return;
		} else {
			for (int j = 1; j <= n; j++) {
				if (cot[j] == 0 && duongCheoNguoc[i + j - 1] == 0 && duongCheoXuoi[n + i - j] == 0) {
					hang[i] = j;
					cot[j] = 1;
					duongCheoNguoc[i + j - 1] = 1;
					duongCheoXuoi[n + i - j] = 1;
					backTrack(i + 1);
					cot[j] = 0;
					duongCheoNguoc[i + j - 1] = 0;
					duongCheoXuoi[n + i - j] = 0;
				}
			}

		}
	}

	void solution() {
		init();
		backTrack(1);
		System.out.println(count);
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai18.txt"));
		Bai18 b = new Bai18();
		b.solution();
	}
}
