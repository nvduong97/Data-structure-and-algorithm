package thi_ktlthdt;
import java.util.*;
public class Bai12 {
    public static int M= 1000000007;
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int t = in.nextInt();
        while(t-->0){
            int n= in.nextInt();
            int k = in.nextInt();
            long[][] a= new long[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j]=in.nextInt();
                }
            }
            print(pow(a, k)); 
        }
    }
    public static void print(long[][] a){
        int len=a[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static long[][] mul(long[][] a, long[][]b){
        int len=a[0].length;
        long[][] result= new long[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result[i][j]=0;
                for (int k = 0; k < len; k++) {
                    result[i][j]+= a[i][k]*b[k][j];
                    result[i][j] %=  M;
                }
            }
        }
        return result;
    }
    public static long[][] pow(long[][] a,int k){
        if(k==1)return a;
        long [][] x= pow(a, k/2);
        if(k%2==0)return mul(x,x);
        return mul(mul(x,x), a);
    }
}
