package thi_ktlthdt;
import java.util.*;
public class Bai03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int [] arr = new int[n], cnt = new int[n];
            int ans = 0;
            for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
            for(int i = 0; i < n; i++)
                for(int j = 0; j < i; j++)
                    if(arr[j] < arr[i]){
                        cnt[i] = Math.max(cnt[i], cnt[j]+1);
                        ans = Math.max(ans, cnt[i]);
                    }
            System.out.println(ans+1);
        }
    }
}
