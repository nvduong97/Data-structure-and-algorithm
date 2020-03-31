package thi_ktlthdt;
import java.util.*;
public class Bai08 {
    public static void main(String[] args) {
        int t;Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t-- >0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            String n1S = String.valueOf(n).replace('6', '5');
            String m1S = String.valueOf(m).replace('6', '5');
            String n2S = String.valueOf(n).replace('5', '6');
            String m2S = String.valueOf(m).replace('5', '6');
            long r1 = Long.parseLong(n1S) + Long.parseLong(m1S);
            long r2 = Long.parseLong(n2S) + Long.parseLong(m2S);
            System.out.println(r1 + " " + r2);
        }
    }
}