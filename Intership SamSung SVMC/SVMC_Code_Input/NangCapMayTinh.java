package luyentap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NangCapMayTinh {
	Scanner sc = new Scanner(System.in);
	int t, soLinhKien, goiUuDai, gia, soLuongMua;
	int linhKienUuDai, soLuongCanMua, soLuongUuDai;
	int arrGiaLinhKien[][];
	int mua[];
	int visit[];
	int ans, min;

	void init() {
		// min = 999999;
		ans = 1000000;
		gia = 0;
		// soLinhKien+1 bá»‹ time out, pháº£i cáº¥p thÃªm
		arrGiaLinhKien = new int[soLinhKien + 100][soLinhKien + 100];
		mua = new int[soLinhKien + 100];
		visit = new int[soLinhKien + 100];
	}

	void backTrack(int num, int sum) {
		if (sum > ans) {
			return;
		}
		if (num == soLinhKien + 1) {
			if (sum < ans) {
				ans = sum;
			}
			return;
		}
		if (mua[num] == 1) {
			// để chạy từ 0 để tính cả gói ưu đãi trên mạng + vs của chợ trời
			for (int i = 0; i <= goiUuDai; i++) {
				if (visit[i] == 0 && arrGiaLinhKien[num][i] != 0) {
					// nếu mua gói ưu đãi trên mạng thì cần visit, còn mua ở chợ Trời thì ko cần visit
					if (i != 0) {
						visit[i] = 1;
					}
					backTrack(num + 1, sum + arrGiaLinhKien[num][i]);
					visit[i] = 0;
				} else if (i != 0 && visit[i] == 1 && arrGiaLinhKien[num][i] != 0) {
					backTrack(num + 1, sum);
				}
			}
		} else {
			backTrack(num + 1, sum);
		}
	}

	void solution() {
		t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			soLinhKien = sc.nextInt();
			init();
			for (int i = 1; i <= soLinhKien; i++) {
				arrGiaLinhKien[i][0] = sc.nextInt();
			}

			goiUuDai = sc.nextInt();
			for (int i = 1; i <= goiUuDai; i++) {
				gia = sc.nextInt();
				soLuongUuDai = sc.nextInt();
				for (int j = 1; j <= soLuongUuDai; j++) {
					int index = sc.nextInt();
					arrGiaLinhKien[index][i] = gia;
				}
			}
			System.out.println("arrGia");
			for (int i = 1; i <= soLinhKien; i++) {
				for (int j = 0; j <= soLinhKien; j++) {
					System.out.print(arrGiaLinhKien[i][j] + " ");
				}
				System.out.println();
			}
			soLuongMua = sc.nextInt();
			for (int i = 1; i <= soLuongMua; i++) {
				int index = sc.nextInt();
				mua[index] = 1;
			}
//   System.out.println("mua");
//   for(int i=1; i<=soLinhKien; i++){
//    System.out.print(mua[i]+" ");
//   }
//   System.out.println();
			backTrack(1, 0);
			System.out.println("#" + tc + " " + ans);
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("NangCapMayTinh.txt"));
		NangCapMayTinh m = new NangCapMayTinh();
		m.solution();
	}

}