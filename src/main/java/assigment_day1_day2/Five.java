package assigment_day1_day2;

import java.util.Scanner;



public class Five {

    /**
     * Tim uoc chung lon nhat
     *
     * @param a
     * @param b
     * @return sa
     */
    @SuppressWarnings("checkstyle:Indentation")
    private static int findUCLN(int a, int b) {
        int uc = 1;
        if (a >= b) {
            for (int i = 1; i <= b; i++) {
                if (a % i == 0 && b % i == 0) {
                    uc = i;
                }
            }
        } else {
            for (int i = 1; i <= a; i++) {
                if (a % i == 0 && b % i == 0) {
                    uc = i;
                }
            }
        }
        return uc;
    }

    /**
     * Tim boi chung nho nhat
     *
     * @param a: bien a.
     * @param b: bien b.
     * @return Trả về bội chung nhỏ nhất.
     */
    private static int findBCNN(int a, int b) {
        int bc = 0;
        if (a > b) {
            for (int i = a; ; i++) {
                if (i % a == 0 && i % b == 0) {
                    bc = i;
                    break;
                }
            }
        } else {
            for (int i = b; ; i++) {
                if (i % a == 0 && i % b == 0) {
                    bc = i;
                    break;
                }
            }
        }
        return bc;
    }

    /**
     * aaaaaaaa
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("UCLN: " + findUCLN(a, b));
        System.out.println("UCLN: " + findBCNN(a, b));
    }
}
