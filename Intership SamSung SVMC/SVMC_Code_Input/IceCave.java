package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 90/100: time out
/*
 * https://alexishuuuocn.wordpress.com/2019/07/18/ice-cave/
 */
public class IceCave {
    static int t, n, m, r1, c1, r2, c2, st, en, count;
    static int[][] map;
    static int[][] visit;
    static int[] queueX = new int[1000000];
    static int[] queueY = new int[1000000];;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int check;

    static void BFS(int startX, int startY) {
        st = en = 0;
        queueX[en] = startX;
        queueY[en] = startY;
        en++;
        map[startX][startY] = 0;
        while (st != en) {
            int x = queueX[st];
            int y = queueY[st];
            st++;
            for (int i = 0; i < 4; i++) {
                int xNext = x + dx[i];
                int yNext = y + dy[i];
                if (xNext >= 0 && xNext < n && yNext >= 0 && yNext < m) {
                    // if-if nếu thỏa mãn trường hợp trên thì nhảy xuống trường
                    // hợp dưới
                    // if-else if thỏa mãn trương hợp trên thì ko xét trường hợp
                    // dưới nữa
                    if (map[xNext][yNext] == 1) {
                        map[xNext][yNext] = 0;
                        queueX[en] = xNext;
                        queueY[en] = yNext;
                        en++;
                    }
                    // khi đi tới được đích thì đánh dấu check = 1
                    else if (xNext == r2 && yNext == c2) {
                        if (map[xNext][yNext] == 0) {
                            check = 1;
                            return;
                        } 
                        // nếu ko đi tới được đích
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("IceCave.txt"));
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            //System.out.print("#" + tc + " ");
            n = sc.nextInt();
            m = sc.nextInt();
            r1 = sc.nextInt();
            c1 = sc.nextInt();
            r2 = sc.nextInt();
            c2 = sc.nextInt();
            map = new int[n + 10][m + 10];
            //visit = new int[n + 1][m + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            check = 0;
            BFS(r1, c1);
            if (check == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
