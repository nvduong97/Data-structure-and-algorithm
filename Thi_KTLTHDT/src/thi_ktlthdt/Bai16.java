package thi_ktlthdt;
import java.util.*;
public class Bai16 {
    static final int N = 20005;
    public static int bfs(int s, int t) {
        int d[] = new int[N];
        for (int i = 1; i < N; ++i) {
            d[i] = 0;
        }
        d[s] = 1;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(s);
        while (qu.size() > 0) {
            int u = qu.poll(),v1 = u - 1, v2 = u*2;
            if (v1 >= 1 && v1 < N && d[v1] == 0) {
                d[v1] = d[u] + 1;
                qu.add(v1);
            }
            if (v2 >= 1 && v2 < N && d[v2] == 0) {
                d[v2] = d[u] + 1;
                qu.add(v2);
            }
        }
        return d[t] - 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-->0) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            System.out.println(bfs(s, t));
        }
    }
}
