package assigment_day1_day2;

import java.util.Scanner;
import java.util.Stack;

public class Six {
    /**
     * Quy doi n ra he nhi phan
     *
     * @param args sss
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stacks = new Stack<>();
        while (n > 0) {
            int x = n % 2;
            n = n / 2;
            stacks.push(x);
        }
        while (!(stacks.isEmpty())) {
            System.out.print(stacks.pop());
        }
    }
}
