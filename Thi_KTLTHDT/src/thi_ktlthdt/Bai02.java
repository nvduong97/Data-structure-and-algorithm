package thi_ktlthdt;
import java.util.Scanner;
public class Bai02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t,n,i,j,max;
        t = in.nextInt();
        while(t-->0){
            n = in.nextInt();
            int[] A = new int[n], D = new int[n];
            for(i = 0; i<n; i++) A[i] = in.nextInt();
            for(i = 0; i < n; i++)
                for(j = n-1; j >= i; j--)
                    if(A[j] >= A[i]){
                        D[i] = j - i;
                        break;
                    }
            max = 0;
            for(i = 0; i < n; i++)  if(D[i] > max)     max = D[i];
            System.out.println(max);
        }
    }  
}
