package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KiemTraDoThiCoPhaiCayKhong {
	Scanner sc = new Scanner(System.in);
	int n,a,b,t;
	void solution() {
		t = sc.nextInt();
		while(t-- > 0) {
			n = sc.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			for(int i=1; i<=n-1; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				if(!list.contains(a)) {
					list.add(a);
				}
				if(!list.contains(b)) {
					list.add(b);
				}
			}
			if(list.size() == n) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			list.clear();
		}
		
	}
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		KiemTraDoThiCoPhaiCayKhong kiemTraDoThiCoPhaiCayKhong = new KiemTraDoThiCoPhaiCayKhong();
		kiemTraDoThiCoPhaiCayKhong.solution();
	}

}
