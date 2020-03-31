package OnTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Chuyendanhsachkesangmatranke {
	static int a[][] = new int[1001][1001];
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("list_ke_to_matranke.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		int n;
		n = Integer.parseInt(sc.nextLine());
		String dinh, dinhKe[];
		int i;
		// tới phần nhập các đỉnh kề chú ý phần con trỏ file trong java vs lại các chỗ next(), nextLine(), nextInt(), ... khác nhau rất là nhiều
		for(i=1; i<=n; i++) {
			dinh = sc.nextLine(); // nhập các đỉnh kề vào
			dinhKe = dinh.split(" "); // tách các đỉnh ra cách nhau bằng khoảng cách
			for(String j:dinhKe) {
				int chiSo = Integer.parseInt(j);
				a[chiSo][i] = a[i][chiSo] = 1;
			}
		}
		for(i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}
