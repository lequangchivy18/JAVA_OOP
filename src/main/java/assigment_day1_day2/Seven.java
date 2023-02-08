package assigment_day1_day2;

import java.util.HashMap;
import java.util.Scanner;

public class Seven {
    public static void main(String[] args) {
        Seven sv = new Seven();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sv.daoStr(s);
        System.out.println("Nhap m - n:");
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        sv.subString(s, m, n);
    }

    /**
     * Viet hoa cho chuoi
     *
     * @param s
     */
    private static void upperStr(String s) {
//        System.out.println(s.toUpperCase());
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (ch > 96 && ch < 123) {
                ch = ch - 32;
                System.out.print((char) ch);
            } else {
                System.out.print((char) ch);
            }
        }
    }

    /**
     * Viet thuong cho chuoi
     *
     * @param s
     */
    private static void lowerStr(String s) {
//        System.out.println(s.toLowerCase());
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (ch > 64 && ch < 91) {
                ch = ch + 32;
                System.out.print((char) ch);
            } else {
                System.out.print((char) ch);
            }

        }
    }

    /**
     * Dem so luong cua cac ki tu trong chuoi
     *
     * @param s
     */
    private static void countWord(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i) + "")) {
                map.put(s.charAt(i) + "", map.get(s.charAt(i) + "") + 1);
            } else {
                map.put(s.charAt(i) + "", 1);
            }
        }
        System.out.println(map.toString());
    }

    /**
     * Dao Chuoi
     *
     * @param s
     */
    private void daoStr(String s) {
        StringBuilder str = new StringBuilder(s);
        System.out.println(str.reverse().toString());
        upperStr(s);
        System.out.println();
        lowerStr(s);
        System.out.println();
        countWord(s);
    }

    /**
     * Trich chuoi con tu vi tri n den m
     *
     * @param s
     * @param m
     * @param n
     */
    private void subString(String s, int m, int n) {
        if (n > m && n < s.length() && m > 0 && n > 0) {
            System.out.print(s.substring(m, n));
        } else if (m < s.length() && n > 0 && m > 0) {
            System.out.print(s.substring(n, m));
        } else {
            System.out.print("Khong hop le");
        }
    }


}