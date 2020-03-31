package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bai24 {

    int testCase, n;
    Scanner sc = new Scanner(System.in);
    int tien[] = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};

    void solution() {
        testCase = sc.nextInt();
        while (testCase-- > 0) {
            int count = 0;
            n = sc.nextInt();
            for (int i = tien.length - 1; i >= 0; i--) {
                if (n % tien[i] == 0) {
                    count += n / tien[i];
                    break;
                } else {
                    count += n / tien[i];
                    n = n % tien[i];
                }
            }
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai24.txt"));
        Bai24 b = new Bai24();
        b.solution();
    }
}
