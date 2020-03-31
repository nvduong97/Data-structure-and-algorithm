package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Bai3 { // day con tang dai nhat

    Scanner sc = new Scanner(System.in);
    int n;
    int a[];
    int l[];

    void solution() {
        n = sc.nextInt();
        a = new int[n];
        l = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        l[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && l[j] + 1 > l[i]) {
                    l[i] = l[j] + 1;
                }
            }
        }
        Arrays.sort(l);
        System.out.println(l[n - 1]);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai1.txt"));
        Bai3 bai1 = new Bai3();
        bai1.solution();
    }

}
