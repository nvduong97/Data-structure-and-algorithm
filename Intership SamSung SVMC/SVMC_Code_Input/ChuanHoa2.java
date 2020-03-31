package OnTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChuanHoa2 {
	static String xuLy(String s) {
		s=s.trim();
		s=s.toLowerCase();
		s=s.replaceAll("\\s++", " ");
		String hoTen[] = s.split(" ");
		StringBuffer s1;
		StringBuffer s2 = new StringBuffer();
		for(int i=1; i<hoTen.length; i++) {
			s1 = new StringBuffer(hoTen[i]);
			s1.setCharAt(0, Character.toUpperCase(s1.charAt(0)));
			s2.append(s1+" ");
		}
		s2.deleteCharAt(s2.length()-1);
		s2.append(", "+hoTen[0].toUpperCase());
		
		return s2.toString();
	}
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("chuanhoa2.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		int t;
		t = Integer.parseInt(sc.nextLine());
		String s;
		while(0!=t--) {
			s = sc.nextLine();
			System.out.println(xuLy(s));
		}
	}

}
