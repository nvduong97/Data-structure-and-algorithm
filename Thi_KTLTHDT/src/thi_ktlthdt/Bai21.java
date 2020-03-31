package thi_ktlthdt;
import java.util.*;
public class Bai21 {
	public static int charToNum(char c){
            String s = "0abcdefgh";
            return s.indexOf(""+c);
	}
	public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int T = Integer.parseInt(sc.nextLine());
            int dx[] = {-1,-1,1,1,-2,-2,2,2};
            int dy[] = {-2,2,-2,2,-1,1,-1,1};
            while(T-->0){
		int[][] map = new int[9][9];
		boolean checked[][] = new boolean[9][9];
		String start = sc.next();
		String end = sc.next();
		int xStart = charToNum(start.charAt(0));
		int yStart = start.charAt(1) - '0';
		int xEnd = charToNum(end.charAt(0));
		int yEnd = end.charAt(1) - '0';
		int queue[] = new int[100000];
		int top = 0,bottom = -1;
		queue[++bottom] = xStart;
		queue[++bottom] = yStart;
		checked[xStart][yStart] = true;
		boolean result = false;
		int level[][] = new int[9][9];
		while(top < bottom && !result){
			int x = queue[top++];
			int y = queue[top++];
			for (int i = 0; i < 8; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				if (newX>=1 && newX<=8 && newY>=1 && newY<=8 && !checked[newX][newY]){
                                    queue[++bottom] = newX;
                                    queue[++bottom] = newY;
                                    checked[newX][newY] = true;
                                    level[newX][newY] = level[x][y] + 1;
                                    if (newX == xEnd && newY == yEnd) break;
				}
			}
		}
		System.out.println(level[xEnd][yEnd]);
            }
    }
}
