package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Bai15 {

    Scanner sc = new Scanner(System.in);
    int t, n, k;
    int arr[];
    int x[] = new int[100];
    // sinh cấu hình tiếp theo

    void nextCombination() {
        int i = k - 1;
        while (i >= 1 && x[i] == n - k + i) {
            i--;
        }
        if (i > 0) {
            x[i]++;
            i++;
            while (i <= k) {
                x[i] = x[i - 1] + 1;
                i++;
            }
        }
    }

    void solution() {
        t = sc.nextInt();
        while (t-- > 0) {
            int count = 0;
            n = sc.nextInt();
            k = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= k; i++) {
                x[i] = sc.nextInt();
                set.add(x[i]);
            }
            nextCombination();
            for (int i = 1; i <= k; i++) {
                if (!set.contains(x[i])) {
                    count++;
                }
            }
            if (count != 0) {
                System.out.println(count);
            } else {
                System.out.println(k);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//		System.setIn(new FileInputStream("Bai15.txt"));
        Bai15 bai15 = new Bai15();
        bai15.solution();
    }

}
