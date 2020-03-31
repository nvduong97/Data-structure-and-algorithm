package backtracking;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* đề bài:chia làm n phần sao cho tổng chi phí chia là nhỏ nhất
*mỗi 1 lần chia chỉ chia được làm đôi thôi
* 
*/
public class Partition1 {
	 static void Sort(int n, int a[]) {
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = i + 1; j < n; j++) {
	                if (a[i] > a[j]) {
	                    int temp = a[i];
	                    a[i] = a[j];
	                    a[j] = temp;
	                }
	            }
	        }
	    }

	    public static void main(String[] args) {
	        try {
	            System.setIn(new FileInputStream("Partition1.txt"));
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        Scanner sc = new Scanner(System.in);
	        int tc, T, n;
	        T = sc.nextInt();
	        for (tc = 1; tc <= T; tc++) {
	            // n = Integer.parseInt(sc.nextLine());
	            n = sc.nextInt();
	            int[] a = new int[n + 9];
	            int i, j;
	            int sum = 0;
	            for (i = 0; i < n; i++) {
	                a[i] = sc.nextInt();
	            }
	            Sort(n, a);
	            int m = 999999;
	            for (i = 0; i < n-1; i++) {
	                a[0]+=a[1];
	                a[1]=m;
	                sum += a[0];
	                Sort(n, a);
	                
	            }
	            System.out.println("Case #" + tc + "");
	            System.out.println(sum);
	        }

	    }
}
