package test;
// đổi vị trí của các số trong 1 dãy số liên tiếp sau k lần đổi để được số lớn nhất có thể
// dãy số nhiều nhất là 6 số, và k lớn nhất là 10 lần đổi
// làm backtrack cẩn thận bài này ko có time out
// ý tưởng bài này là liệt kê các hoán vị 32888 sẽ sinh ra thêm 4 hoán vị sau 1 lần đổi 82388, 82838, 82883, 23888 và các hoán vị lại đổi chỗ cho nhau 
// viết hàm swap trong java này ko giống như trong C vì ko có con trỏ vs địa chỉ vào nên kết quả sai nên ta viết thẳng vào trong hàm chính
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EarningBiggestPrizeMoney2 {
	static int t, k, l, ans, result;
	static String s;
	static char []str;
	static int []a;
	static int []b;
	static void backTrack(int n) {
		if(ans == result) { // kết quả bằng cấu hình lớn nhất rồi thì dừng lại khỏi phải duyệt nữa
			return;
		}
		// dieu kien dung khi n bang 0
		// lấy ra cấu hình lớn nhất rồi return
		if(n==0) {
			int sum = str[0] - '0';
			for(int i=1; i<l; i++) {
				sum = sum*10 + (str[i] - '0');
			}
			if(sum > ans) {
				ans = sum;
			}
			return;
		}
		// n!=0
		// chú ý vị trí đổi không có bị nhầm và fail test case 37 2 => 37 mới đúng, nếu for i=0 -> i<l && j=0 -> j<l thì dính ngay
		for(int i=0; i<l-1; i++) {
			for(int j=i+1; j<l; j++) {
				char te = str[i]; str[i]=str[j]; str[j]=te;
				backTrack(n-1);
				te = str[i]; str[i]=str[j]; str[j]=te;
			}
		}
		
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("EarningBiggestPrizeMoney2.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			s = sc.next(); // nó sẽ đọc chuỗi ký tự này cho tới khi nào gặp khoảng trắng thì dừng lại nên next() chứ ko phải nextline()
			k = sc.nextInt();
			str = s.toCharArray();
			l = str.length;
			a = new int[l+1];
			for(int i=0; i<l; i++) {
				a[i] = str[i] - '0';
			}
			for(int i=0; i<l-1; i++) {
				for(int j=i+1; j<l; j++) {
					if(a[i] < a[j]) {
						int temp = a[i]; a[i]=a[j]; a[j]=temp;
					}
				}
			}
			result = a[0];
			for(int i=1; i<l; i++) {
				result = result*10 + a[i];
			}
			ans=0;
			backTrack(k);
			System.out.println("#"+tc+" "+ans);
			
		}
	}

}
