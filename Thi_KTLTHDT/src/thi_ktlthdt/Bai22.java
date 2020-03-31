package thi_ktlthdt;
import java.util.*;
public class Bai22 {
        static LinkedList<Integer>[] dsKe;
	static int t,n,m;
	static int A[][];
	static boolean chuaXet[];
	static ArrayList<Integer> count;
	public static int BFS(int u){
		int dem = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(u);
		chuaXet[u] = false;
		while(!queue.isEmpty()){
			int s = queue.poll();
			dem++;
			for (int i : dsKe[s]) {
				if(chuaXet[i]){
					queue.add(i);
					chuaXet[i] = false;
				}
			}
		}
		return dem;
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		while(t-- >0){
			count = new ArrayList<>();
			n = sc.nextInt();
			m =sc.nextInt();
			dsKe = new LinkedList[n+1];
			for(int i =1;i<=n;i++){
				dsKe[i] = new LinkedList<>();
			}
			int a,b;
			for(int i=0;i<m;i++){
				a = sc.nextInt();
				b = sc.nextInt();
				dsKe[a].add(b);
				dsKe[b].add(a);
			}
			chuaXet = new boolean[n+1];
			for(int i=1;i<=n;i++){
				chuaXet[i] = true;
			}
			for(int i=1;i<=n;i++){
				if(chuaXet[i]){
					count.add(BFS(i));
				}
			}
			int max = count.get(0);
			for(int i:count){
				if(i>max){
					max = i;
				}
			}
			System.out.println(max);
		}
	}
}
