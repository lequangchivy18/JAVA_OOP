package assigment_day1_day2;

import java.util.Scanner;

public class Four_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap m: ");
        int m = sc.nextInt();
        String str = m + "";
        int lengthStr = str.length();
        int a;
        int S = 0;
        int P = 1;
        for (int i = lengthStr; i > 0; i--) {
            a = m % 10;
            m = m / 10;
            S += a;
            P *= a;
        }
        System.out.println("Tong: " + S);
        System.out.print("Tich: " + P);
    }
}
