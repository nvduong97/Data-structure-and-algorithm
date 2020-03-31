package thi_ktlthdt;
import java.util.*;
public class Bai05 {
    public static void main(String[] args) {
        boolean[] a = new boolean[10];
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            Arrays.fill(a, 0, 9, false);
            int n = s.nextInt();
            for(int j=0; j<n; j++){
                String str = s.next();
                for(char c:str.toCharArray()){
                    a[Integer.parseInt(String.valueOf(c))] = true;
                }
            }
            for(int i = 0; i<a.length; i++){
                if(a[i]) System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
