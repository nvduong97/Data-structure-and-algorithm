package thi_ktlthdt;
import java.util.*;
public class Bai18 {
    public static int timMax(String s){
        int start=0, end=0;
        for(int i=0; i<s.length();i++){
            int len1 = timLen(s,i,i);
            int len2 = timLen(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len>(end-start)){
                start = i-(len-1)/2;
                end = i +len/2;
            }
        }
        return end-start+1;
    }
    public static int timLen(String s, int l, int r) {
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0){
            String s = sc.nextLine();
            System.out.println(timMax(s));
        }
    }
}
