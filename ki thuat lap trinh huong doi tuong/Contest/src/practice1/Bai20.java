package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Bai20 {

    Scanner sc = new Scanner(System.in);
    int n, s;
    int a[];
    int soTo = 0;

    void solution() {
        n = sc.nextInt();
        s = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //Arrays.sort(a);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (s % a[i] == 0) {
                soTo += s / a[i];
                break;
            } else {
                soTo += s / a[i];
                s = s % a[i];
            }
        }
        System.out.println(soTo);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai20.txt"));
        Bai20 bai20 = new Bai20();
        bai20.solution();
    }

}
