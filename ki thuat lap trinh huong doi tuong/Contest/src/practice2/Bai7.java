package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Bai7 { // sap xep lai day con

    Scanner sc = new Scanner(System.in);
    int n, t;
    int a[], a2[];

    void solution() {
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            a = new int[n];
            a2 = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                a2[i] = a[i];
            }
            Arrays.sort(a2);
            int positions = 0;
            for (int i = 0; i < n; i++) {
                if (a[i] != a2[i]) {
                    positions = i;
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (a[i] != a2[i]) {
                    positions = i - positions + 1;
                    break;
                }
            }
            if (positions == 0) {
                System.out.println("YES");
            } else {
                System.out.println(positions);
            }

        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai1.txt"));
        Bai7 bai1 = new Bai7();
        bai1.solution();
    }

}
