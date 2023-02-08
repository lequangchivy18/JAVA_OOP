package assigment_day1_day2;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float sum = 0.0f;
        for (int i = 1; i <= n; i++) {
            sum += 1.0f / i;
        }
        System.out.print(sum);
    }
}
