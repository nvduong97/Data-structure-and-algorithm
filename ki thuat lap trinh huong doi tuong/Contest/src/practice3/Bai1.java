package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// quy hoach dong
public class Bai1 { // xem phim
    Scanner sc = new Scanner(System.in);
    int c, n;
    int w[];
    int f[][] = new int[101][25000];
    int max(int a, int b) {
        return a > b ? a : b;
    }

    void solution() {
        c = sc.nextInt();
        n = sc.nextInt();
        w = new int[n + 1];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = max(f[i - 1][j], j >= w[i - 1] ? w[i - 1] + f[i - 1][j - w[i - 1]] : 0);
                }
            }
        }
        System.out.println(f[n][c]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Bai1 bai1 = new Bai1();
        bai1.solution();
    }

}
