package ontap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DiaChiEmailPTIT {
	Scanner sc = new Scanner(System.in);
	int testCase;
	String str;
	List<String> list = new ArrayList<String>();

	void process(String s) {
		s = s.trim();
		s = s.replaceAll("\\s++", " ");
		s = s.toLowerCase();
		String s2[] = s.split(" ");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(s2[s2.length - 1]);
		for (int i = 0; i < s2.length - 1; i++) {
			stringBuilder.append(s2[i].charAt(0));
		}
		list.add(stringBuilder.toString());
		int count=0;
		for(String element:list) {
			if(stringBuilder.toString().equals(element)) {
				count++;
			}
			//System.out.println(element);
		}
		if(count >= 2) {
			stringBuilder.append(count);
		}
		
		
		stringBuilder.append("@ptit.edu.vn");
		System.out.println(stringBuilder.toString());
	}

	void solution() {
		testCase = sc.nextInt();
		sc.nextLine();
		while (testCase-- > 0) {
			str = sc.nextLine();
			process(str);
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("Bai1.txt"));
		DiaChiEmailPTIT diaChiEmailPTIT = new DiaChiEmailPTIT();
		diaChiEmailPTIT.solution();
	}

}
