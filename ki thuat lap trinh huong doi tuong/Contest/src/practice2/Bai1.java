package practice2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai1 { // bai 1: sap xep doi cho truc tiep

    Scanner sc = new Scanner(System.in);
    int n;
    int a[];

    void solution() {
        n = sc.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            System.out.print("Buoc " + (i + 1) + ": ");
            for (int k = 0; k < n; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai1.txt"));
        Bai1 bai1 = new Bai1();
        bai1.solution();
    }

}
