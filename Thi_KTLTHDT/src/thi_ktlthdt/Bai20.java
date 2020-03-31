package thi_ktlthdt;
import java.util.*;
public class Bai20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
	int n = in.nextInt(),m = in.nextInt();
	int[][] a = new int[n + 1][n + 1];
	for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
		if (i == j) a[i][j] = 0;
		else a[i][j] = 1001;
            }
        }
	for (int i = 0; i < m; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            int cost = in.nextInt();
            a[v1][v2] = cost;
            a[v2][v1] = cost;
	}
	for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
                    if (a[i][j] > a[i][k] + a[j][k]) {
			a[i][j] = a[i][k] + a[j][k];
                    }
		}
            }
	}
        int q = in.nextInt();
        while (q-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(a[x][y]);
        }
    }
}
