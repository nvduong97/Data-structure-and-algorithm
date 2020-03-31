package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai4 {

    Scanner sc = new Scanner(System.in);
    int t, n, number;
    int arr[], xuatHien[];
    int count[];

    void solution() {
        t = sc.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            System.out.println("Test " + tc + ":");
            n = sc.nextInt();
            arr = new int[n + 1];
            xuatHien = new int[100001];
            count = new int[100001];
            for (int i = 1; i <= n; i++) {
                number = sc.nextInt();
                arr[i] = number;
                ++count[number];
            }
            for (int i = 1; i <= n; i++) {
                if (count[arr[i]] > 0 && xuatHien[arr[i]] == 0) {
                    xuatHien[arr[i]]++;
                    System.out.println(arr[i] + " xuat hien " + count[arr[i]] + " lan");
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai4.txt"));
        Bai4 b = new Bai4();
        b.solution();
    }

}
