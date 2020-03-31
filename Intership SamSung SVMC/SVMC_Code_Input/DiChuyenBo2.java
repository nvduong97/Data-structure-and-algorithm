package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * nhập vào khối lượng xe tải, số con bò
 * khối lượng từng con bò một
 * hỏi xem xe tải có thể chở nặng tối đa bao nhiêu kg từ số bò đã cho
 * 
 * giải thuật: sinh nhị phân, vs mỗi trường hợp xét xem có hợp lệ ko & lấy kết quả cao nhất
 * 
 */
public class DiChuyenBo2 {
	Scanner sc = new Scanner(System.in);
	int t,n,m,ans;
	int data[], visit[];
	void init() {
		ans = 0;
		data = new int[n+1];
		visit = new int[n+1];
	}
	void sinhNhiPhan(int num) {
		if(num == n+1) {
			int sum=0;
			for(int i=1; i<=n; i++) {
				if(visit[i]==1) {
					sum+=data[i];
				}
			}
			if(sum <= m) {
				if(sum > ans) {
					ans = sum;
				}
				return;
			}
		}else {
			visit[num]=0;
			sinhNhiPhan(num+1);
			visit[num]=1;
			sinhNhiPhan(num+1);
		}
	}
	void solution() {
		t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			m = sc.nextInt();
			n = sc.nextInt();
			init();
			for(int i=1; i<=n; i++) {
				data[i] = sc.nextInt();
			}
			sinhNhiPhan(1);
			System.out.println("Case #"+tc+" "+ans);
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("DiChuyenBo.txt"));
		DiChuyenBo2 d = new DiChuyenBo2();
		d.solution();
	}

}
