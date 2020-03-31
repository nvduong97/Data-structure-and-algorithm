package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai2 { // xau con chung dai nhat

    Scanner sc = new Scanner(System.in);
    String s1, s2;
    int a[][];

    void solution() {
        s1 = sc.nextLine();
        s2 = sc.nextLine();
        int n1 = s1.length();
        int n2 = s2.length();
        a = new int[n2 + 1][n1 + 1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    a[i + 1][j + 1] = a[i][j] + 1;
                } else {
                    a[i + 1][j + 1] = Math.max(a[i + 1][j], a[i][j + 1]);
                }
            }
        }
        System.out.println(a[n2][n1]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai1.txt"));
        Bai2 bai1 = new Bai2();
        bai1.solution();
    }

}
