package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Bài này ngày trước cho vào thi ACM mà cứ bị TLM, là do ko chặt được cái khoảng thời gian xử lý phần còn lại của ước số từ bé đi lên sau khi chia
public class Bai22 {

    Scanner sc = new Scanner(System.in);
    int t, n;

    void solution() {
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            if (n % 2 != 0) {
                System.out.println("0");
            } else {
                int count = 1; // vì số chẵn thì mặc định số đó chia hết cho 2 rồi
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        if (i % 2 == 0) {
                            count++;
                        }
                        int d = n / i;
                        if (d != i && d % 2 == 0) {
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("Bai22.txt"));
        Bai22 b = new Bai22();
        b.solution();
    }
}
