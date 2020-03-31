package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
// http://www.hoangvancong.com/2016/10/27/backtracking-domino/
public class Domino {
	static int t,n, ans;
	static int [][]data = new int[7][8];
	static int [][]visitDinh = new int[7][8];
	static int [][]domino = new int[7][8];
	static void backTrack(int index) {
		if(index>=56) { // neu duyet het tat ca cac dinh thi dem so lan hoan vi cac domino
			ans++;
			return;
		}
		// tim toa do dinh dang xet
		int x = index/8;
		int y = index%8;
		if(visitDinh[x][y] == 1) { // neu da visit roi
			backTrack(index+1); // duyet tiep dinh tiep theo
		}
		else { // neu chua visit index
			// duyet ngang
			if(y>=0 && y<7 && visitDinh[x][y+1]==0 && domino[data[x][y]][data[x][y+1]] == 0) {
				visitDinh[x][y+1]=1;
				domino[data[x][y]][data[x][y+1]] =1;
				domino[data[x][y+1]][data[x][y]] =1;
				backTrack(index+2);
				// visit xong thì trả lại để còn xét các trường hợp tiếp theo
				visitDinh[x][y+1]=0;
				domino[data[x][y]][data[x][y+1]] =0;
				domino[data[x][y+1]][data[x][y]] =0;
			}
			
			// duyet doc
			if(x>=0 && x<6 && visitDinh[x+1][y]==0 && domino[data[x][y]][data[x+1][y]]== 0) {
				visitDinh[x+1][y]=1;
				domino[data[x][y]][data[x+1][y]] =1;
				domino[data[x+1][y]][data[x][y]] =1;
				backTrack(index+1);
				// visit xong thì trả lại để còn xét các trường hợp tiếp theo
				visitDinh[x+1][y]=0;
				domino[data[x][y]][data[x+1][y]] =0;
				domino[data[x+1][y]][data[x][y]] =0;
			}
		}
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("CoverRectangleWithDominos.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			for(int i=0; i<7; i++) {
				for(int j=0; j<8; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			ans=0;
			backTrack(0);
			System.out.println("#"+tc);
			System.out.println(ans);
		}
	}

}
