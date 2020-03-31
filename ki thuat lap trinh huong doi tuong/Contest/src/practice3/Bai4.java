package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Bai4 { // day con co tong ban S

    Scanner sc = new Scanner(System.in);
    int n, s;
    int A[];
    int F[];

    void solution() {
        n = sc.nextInt();
        s = sc.nextInt();
        A = new int[n + 1];
        F = new int[s + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
        }
        F[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int t = s; t >= A[i]; t--) {
                if (F[t - A[i]] == 1) {
                    F[t] = 1;
                }
            }
        }
        if (F[s] == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai1.txt"));
        Bai4 bai1 = new Bai4();
        bai1.solution();
    }

}
