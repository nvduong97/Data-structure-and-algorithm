package thi_ktlthdt;
import java.math.BigInteger;
import java.util.*;
public class Bai15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            Queue<String> q = new LinkedList();
            q.add("1");
            while(true){
                String front = q.poll();
                BigInteger bdn = new BigInteger(front);
                String sn = ""+n;
                BigInteger nValue = new BigInteger(sn);
                if(bdn.mod(nValue).equals(BigInteger.ZERO)){
                    System.out.println(bdn);
                    break;
                }
                q.add(bdn + "0");
                q.add(bdn + "1");
            }
        }
    }
}
