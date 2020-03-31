package thi_ktlthdt;
import java.util.*;
public class Bai01 {
    public static void main(String[] args) {
        int t; String s; Scanner in = new Scanner(System.in);
        t=in.nextInt();
        while(t-->0){
            s=in.next();
            System.out.println(xuly(s));
        }
    }
    public static String xuly(String s){
        int l = s.length(), index = -1;
        for (int i = l - 2; i >= 0; i--) {
            if (s.charAt(i) > s.charAt(i+1)){
                index = i;
                break;
            }
        }
        int x = -1;
        for (int i = l - 1; i > index; i--) {
            if (s.charAt(i) < s.charAt(index)) {
                if (x == -1) x=i;
                else if (s.charAt(i) >= s.charAt(x))
                    x = i;
            }
        }
        if (index == -1) return "-1";
        if (x != -1){
            char c1 = s.charAt(index), c2=s.charAt(x);
            StringBuilder b = new StringBuilder(s);
            b.setCharAt(index, c2);
            b.setCharAt(x, c1);
            return b.toString();
        }   
        return "-1";
    }
}
