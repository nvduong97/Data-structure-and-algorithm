package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// chỗ hoán vị các thành phố khá là giống cleaning robot
public class Bai21 {

    Scanner sc = new Scanner(System.in);
    int n;
    int a[][];
    int cost = 999999;
    boolean visit[];

    void backTrack(int sum, int start, int count) {
        if (count == n - 1) {
            if (sum < cost) {
                cost = Math.min(cost, sum + a[start][0]);
                // người du lịch xuất phát từ thành phố 1
            }
            return;
        }
        if (count < n - 1 && sum < cost) {
            for (int i = 1; i < n; i++) {
                if (visit[i] == false) {
                    visit[i] = true;
                    backTrack(sum + a[start][i], i, count + 1);
                    visit[i] = false;
                }
            }
        }

    }

    void solution() {
        n = sc.nextInt();
        a = new int[n][n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        backTrack(0, 0, 0);
        System.out.println(cost);
    }

    public static void main(String[] arg) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai21.txt"));
        Bai21 bai21 = new Bai21();
        bai21.solution();

    }
}
