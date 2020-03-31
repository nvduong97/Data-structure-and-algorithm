package thi_ktlthdt;
import java.util.*;
public class Bai09 {
 	public static PriorityQueue<Long> list = new PriorityQueue<Long>();
	public static long M = (long) 1e9+7;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		for(int i = 0; i < n; i++){
			list.add(in.nextLong());
		}
		System.out.println(xuLy(n));
	}
	public static long xuLy(long n) {
		long result = 0,sum = 0;
		while(list.size() > 1){
			sum = 0;
			long a = list.remove();
			long b = list.remove();
			sum = (sum+a+b)%M;
			result = (result+sum)%M;
			list.add(sum);
		}
		return result;
	}
}
