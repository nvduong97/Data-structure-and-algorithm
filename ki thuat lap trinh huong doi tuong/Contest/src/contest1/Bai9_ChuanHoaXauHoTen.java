package contest1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai9_ChuanHoaXauHoTen {
	Scanner sc = new Scanner(System.in);
	int t;
	String s;

	void solution() {
		t = Integer.parseInt(sc.nextLine());
		while (t-- > 0) {
			s = sc.nextLine();
			s = s.trim();
			s = s.toLowerCase();
			s = s.replaceAll("\\s++", " ");
			String str[];
			str = s.split(" ");
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 1; i < str.length; i++) {
				stringBuilder.append(Character.toUpperCase(str[i].charAt(0)) + str[i].substring(1));
				stringBuilder.append(" ");
			}
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
			stringBuilder.append(", ");
			String s1 = str[0].toUpperCase();
			stringBuilder.append(s1);
			System.out.println(stringBuilder.toString());
		}
	}

//	void solution() {
//		t = Integer.parseInt(sc.nextLine());
//		while (t-- > 0) {
//			s = sc.nextLine();
//			s = s.trim();
//			s = s.toLowerCase();
//			s = s.replaceAll("\\s++", " ");
//			String str[];
//			str = s.split(" ");
//			StringBuilder stringBuilder1;
//			StringBuilder stringBuilder2 = new StringBuilder();
//			for (int i = 1; i < str.length; i++) {
//				stringBuilder1 = new StringBuilder(str[i]);
//				stringBuilder1.setCharAt(0, Character.toUpperCase(stringBuilder1.charAt(0)));
//				stringBuilder2.append(stringBuilder1 + " ");
//			}
//			stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
//			stringBuilder2.append(", ");
//			stringBuilder2.append(str[0].toUpperCase());
//			System.out.println(stringBuilder2.toString());
//		}
//	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai12.txt"));
		Bai9_ChuanHoaXauHoTen chuanHoa = new Bai9_ChuanHoaXauHoTen();
		chuanHoa.solution();
	}

}
