package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai3 {

    Scanner sc = new Scanner(System.in);
    int t, n;
    int a[], l[];

    void solution() {
        t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            n = sc.nextInt();
            a = new int[n];
            l = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                l[i] = 1;
            }
            System.out.println("Test " + tc + ":");
            for (int i = 1; i < n; i++) {
                if (a[i] > a[i - 1]) {
                    l[i] = l[i - 1] + 1;
                } else {
                    l[i] = 1;
                }
            }
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (l[i] > max) {
                    max = l[i];
                }
            }
            System.out.println(max);
            for (int i = 0; i < n; i++) {
                if (l[i] == max) {
                    for (int p = i - max + 1; p <= i; p++) {
                        System.out.print(a[p] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai3.txt"));
        Bai3 bai3 = new Bai3();
        bai3.solution();
    }
}
