package thi_ktlthdt;
import java.util.*;
public class Bai10 {
    static int n,cot[],cheoXuoi[],cheoNguoc[],count = 0;
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	cot = new int[n+1];
	cheoXuoi = new int[2 * n];
	cheoNguoc = new int[2 * n];
	Try(0);
	System.out.println(count);
	
    }
    public static void Try(int i) {
        if (i == n ) count++;
	for (int j = 0; j < n; j++) {
            if (cot[j] == 0 && cheoXuoi[i + j] == 0 && cheoNguoc[n + i - j] == 0) {
		cot[j] = 1;
		cheoXuoi[i + j ] = 1;
		cheoNguoc[n + i - j] = 1;
		Try(i+1);
		cot[j] = 0;
		cheoXuoi[i + j ] = 0;
		cheoNguoc[n + i - j] = 0;
            }
	}
    }
}
