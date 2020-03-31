package thi_ktlthdt;
import java.util.*;
public class Bai04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t,n,i,j,A[]=new int[1005];
        t=in.nextInt();
        while(t-->0){
            n=in.nextInt();
            for(i=0;i<n;i++)  A[i]=in.nextInt();
            int B[]=new int[1005];
            B[0]=A[0];
            for(i=1;i<n;i++){
	        for(j=0;j<i;j++){
	            if(A[j]<A[i]){
	                if(A[i]+B[j]>B[i]){
	                    B[i]=A[i]+B[j];
	                }
	            }
	            else if(B[i]>A[i]) continue;
	            else B[i] = A[i];
	        }
	    }
	    int max = Integer.MIN_VALUE;
	    for(i=0;i<n;i++)
	        if(max<B[i]) max = B[i];
	    System.out.println(max);
        }
    }
}
