package assigment_day1_day2;

import java.util.Scanner;

public class Three {
    /**
     * Tính giai thua
     *
     * @param a
     * @return gt
     */
    public static int tinhGT(int a) {
        int gt = 1;
        for (int i = 1; i <= a; i++) {
            gt *= i;
        }
        return gt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0.0f;
        for (int i = 1; i <= (2 * n - 1); i += 2) {
            sum += 1.0f / tinhGT(i);
        }
        System.out.printf("%.2f", sum);
    }
}
