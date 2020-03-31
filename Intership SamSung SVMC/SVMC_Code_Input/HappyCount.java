package luyentap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;
/*
 * Dạo này phải Ctr + S lại mới run được, ko thì nó vẫn cứ run chương trình lần trước
 */
public class HappyCount {
	Scanner sc = new Scanner(System.in);
	int t,n,m,k,ans;
	int nguyenVong[][], room[], visit[];
	void init() {
		ans = 0;
		nguyenVong = new int[n+1][4];
		room =  new int[n+1];
	}
	// đẩy hết tất cả nhân viên vào trong phòng, ưu tiên nguyện vọng 1, đẩy hết vào nguyện vọng 1 rồi 2,3
	void backTrack(int index, int count) {
		if(index == n+1) {
			if(count > ans) {
				ans = count;
			}
			return;
		}
		for(int i=1; i<=m; i++) {
			if(room[i] < k) {
				room[i]++;
				boolean check = false;
				for(int j=1; j<=3; j++) {
					if(nguyenVong[index][j] == i) {
						check = true;
						if(j == 1) backTrack(index+1, count+5);
						if(j == 2) backTrack(index+1, count+3);
						if(j ==3) backTrack(index+1, count+1);
					}
				}
				if(check == false) backTrack(index+1, count);
				room[i]--;
			}
		}
	}
	void solution() {
		t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();
			init();
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=3; j++) {
					nguyenVong[i][j] = sc.nextInt();
				}
			}
			backTrack(1, 0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("HappyCount.txt"));
		HappyCount h = new HappyCount();
		h.solution();
		
	}

}
