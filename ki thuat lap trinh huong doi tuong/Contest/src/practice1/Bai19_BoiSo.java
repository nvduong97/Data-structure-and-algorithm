package practice1;

import java.util.Scanner;

public class Bai19_BoiSo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCount = in.nextInt();
        while (testCount-- > 0) {
            int N = in.nextInt();
            if (N == 0) {
                System.out.println("0");
                continue;
            }
            int num = 1;
            String str = "0";
            while (check(str, N) == false) {
                str = toBin(num);
                num++;
            }
            System.out.println(str);
        }
    }

    public static String toBin(int n) {
        StringBuilder str = new StringBuilder();
        while (n != 0) {
            if (n % 2 == 0) {
                str.append("0");
            } else {
                str.append("9");
            }
            n = n / 2;
        }
        return str.reverse().toString();
    }

    public static boolean check(String str, int num) {
        Integer in = Integer.parseInt(str);
        if (in != 0 && in % num == 0) {
            return true;
        }
        return false;
    }
}
