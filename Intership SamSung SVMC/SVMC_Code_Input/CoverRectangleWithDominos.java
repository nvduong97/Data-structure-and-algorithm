package backtracking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoverRectangleWithDominos {
// link: http://www.hoangvancong.com/2016/10/27/backtracking-domino/
	static int t, result;
	static int [][]data;
	static int [][]visitDomino;
	static int [][]visitDinh;
	static void backTrack(int index) {
		// dieu kien dung
		if(index>=56) {
			result++;
			return;
		}
		// toa do dinh duyet tiep theo
		// dinh dau tien la dinh 0, dinh tiep theo la dinh 1
		int x = index/8;
		int y = index%8;
		if(visitDinh[x][y] == 1) { // neu dinh da duyet thi duyet tiep dinh ke ben
			backTrack(index+1); // duyet lan luot theo thu tu hang ngang toi het
		}
		else {
			// duyet ngang
			if(y<7 && visitDinh[x][y+1] == 0 && visitDomino[data[x][y]][data[x][y+1]]==0) { // cho nay ko duoc x<=7 vi khi do index+2 se nhay ra ngoai hang thu i
				visitDinh[x][y+1] = 1;
				visitDomino[data[x][y]][data[x][y+1]]=1;
				visitDomino[data[x][y+1]][data[x][y]]=1;
				backTrack(index+2); // duyệt ngang nên index + 2 (vẽ hình ra là hiểu)
				// gan tra lai de tinh so lan hoan vi cac domino voi nhau
				visitDinh[x][y+1] = 0;
				visitDomino[data[x][y]][data[x][y+1]]=0;
				visitDomino[data[x][y+1]][data[x][y]]=0;
			}
			// duyet doc
			if(x<6 && visitDinh[x+1][y]==0 && visitDomino[data[x][y]][data[x+1][y]]==0) { // o day cung vay ko duoc x<=6
				visitDinh[x+1][y]=1;
				visitDomino[data[x][y]][data[x+1][y]]=1;
				visitDomino[data[x+1][y]][data[x][y]]=1;
				backTrack(index+1); // duyệt dọc nên khi từ trên xuống nó lại duyệt ngang nên chỉ cộng 1 thôi
				visitDinh[x+1][y]=0;
				visitDomino[data[x][y]][data[x+1][y]]=0;
				visitDomino[data[x+1][y]][data[x][y]]=0;
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
			System.out.println("#"+tc);
			data = new int[7][8];
			visitDinh = new int[7][8]; // chua duyet dinh nao
			visitDomino = new int[7][8]; // chua visit domino nao
			for(int i=0; i<7; i++) {
				for(int j=0; j<8; j++) {
					data[i][j] = sc.nextInt();
				}
			}
			result = 0;
			backTrack(0);
			System.out.println(result);
		}
	}

}
