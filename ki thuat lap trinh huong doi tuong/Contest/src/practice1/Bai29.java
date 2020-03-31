package practice1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Bai29 {

    Scanner sc = new Scanner(System.in);
    int n, k;
    Stack<Integer> stack = new Stack<>();
    String str;

    void solution() {
        n = sc.nextInt();
        k = sc.nextInt();
        str = sc.next();
        for (int i = 0; i < n; i++) {
            int c = str.charAt(i) - '0';
            while (!stack.isEmpty() && c > stack.peek() && k > 0) {
                k--;
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i));
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("Bai29.txt"));
        Bai29 bai29 = new Bai29();
        bai29.solution();
    }

}
