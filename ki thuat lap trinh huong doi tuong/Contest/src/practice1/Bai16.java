package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai16 {

    Scanner sc = new Scanner(System.in);
    int testCase;
    int stt;
    String s;
    int a[];
    int n;

    void result() {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    boolean sinhHoanVi() {
        int i = n - 2;
        while (i > 0 && a[i] >= a[i + 1]) // tim vi tri dau tien ma doan cuoi giam dan
        {
            i--;
        }

        if (i > 0) {
            int k = n - 1; // tim so a[k] nho nhat trong doan giam dan ma a[k] > a[i-1]
            // swap position
            while (a[i] >= a[k]) {
                k--;
            }

            int temp = a[i];
            a[i] = a[k];
            a[k] = temp;
            // dao nguoc doan cuoi giam dan thanh tang dan
            int start = i + 1, end = n - 1;
            while (start <= end) {
                temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                start++;
                end--;
            }
            return true;
        }
        return false;
    }

    void solution() {
        testCase = sc.nextInt();
        for (int tc = 1; tc <= testCase; tc++) {
            stt = sc.nextInt();
            System.out.print(stt + " ");
            s = sc.nextLine();
            s = s.trim();
            n = s.length();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.charAt(i) - '0';
            }
            if (sinhHoanVi() == true) {
                result();
            } else {
                System.out.println("BIGGEST");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("Bai16.txt"));
        Bai16 bai16 = new Bai16();
        bai16.solution();
    }

}
