package thi_ktlthdt;
import java.util.*;
public class Bai17 {
    static int m = 1000000007;
    static int h,k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] a = toHop();
        for(int i = 0 ; i < n ; i++){
            h = sc.nextInt();
            k = sc.nextInt();
            System.out.println(a[h][k]);
        }
    }
    public static int[][] toHop(){
        int[][] a = new int[1001][1001];
        for(int i = 0; i < a.length; i++) a[i][0] = 1;
        for(int i  = 1; i < a.length; i++){
            for(int j =1; j <= i; j++){
                a[i][j] = (a[i-1][j] + a[i-1][j-1])%m;
            }
        }
        return a;
    }
}
