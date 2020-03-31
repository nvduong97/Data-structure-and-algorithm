package OnTap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OneCycleOfPassWord_useQueue_SVMC {

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("OneCycleOfPassWord.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=1; tc++) {
			Queue<Integer> q = new LinkedList<Integer>();
			int t = sc.nextInt();
			int a[] = new int[8];
			for(int i=0; i<8; i++) {
				a[i] = sc.nextInt();
			}
			for(int i=0; i<8; i++) {
				q.add(a[i]);
			}
			int count=1;
			while(true) {
				if(q.peek()-count >=0) {
					int temp = q.peek()-count;
					q.remove();
					q.add(temp);
					count++;
					if(count>5) {
						count=1;
					}
				}
				else {
					int temp=0;
					q.remove();
					q.add(temp);
					break;
				}
			}
			System.out.print("#"+tc+": ");
			while(!q.isEmpty()) {
				System.out.print(q.poll()+" ");
			}
		}
	}

}
