package practice3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai16 {

    public static void main(String[] args) throws FileNotFoundException {
    	System.setIn(new FileInputStream("Bai1.txt"));
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int M[][] = new int[n][m];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    M[i][j] = in.nextInt();
                    if (M[i][j] == 1) {
                        count++;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n-1; j++) {
                    if(M[i][j] == M[i][j+1] && M[i][j] == 1)
                        count--;
                }
            }
            System.out.println(count);

        }
    }
}

