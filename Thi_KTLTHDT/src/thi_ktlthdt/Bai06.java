package thi_ktlthdt;
import java.util.*;
public class Bai06 {
    public static void main(String[] args) {
        int t,m,n,i,j, a[][]= new int[105][105];
        Scanner in = new Scanner(System.in);
        t=in.nextInt();
        while(t-->0){
            m=in.nextInt();n=in.nextInt();
            for(i=0;i<m;i++)
                for(j=0;j<n;j++)
                    a[i][j]=in.nextInt();
            inXoanoc(a,m,n);
        }
    }
    public static void inXoanoc(int a[][],int m,int n){
        int i, k = 0, l = 0;
        while (k < m && l < n) {
            for (i = l; i < n; ++i) System.out.print(a[k][i]+" ");
            k++;
            for (i = k; i < m; ++i) System.out.print(a[i][n-1]+" ");
            n--;
            if (k < m) {
                for (i = n - 1; i >= l; --i) System.out.print(a[m-1][i]+" ");
                m--;
            }
            if (l < n) {
                for (i = m - 1; i >= k; --i) System.out.print(a[i][l]+" ");    
                l++;
            }
        }
        System.out.println();
    }
}