/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest1;

import java.util.Scanner;

/**
 *
 * @author DUONGNV
 */
public class Test {

    static int n;
    static int k;
    static int[] arr;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t;
        t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int[n + 1];
            backTrack(1);
        }
    }

    private static void backTrack(int i) {
        if(i==n+1){
            resutl();
            return;
        }
        for (int j = 0; j <= 1; j++) {
            arr[i] = j;
            backTrack(i+1);
        }
    }

    private static void resutl() {
        for (int i = 1; i < n+1; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
 }
}
