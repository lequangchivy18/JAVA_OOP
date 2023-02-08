package assigment_day1_day2;

import java.util.Scanner;

public class Four {
  /**
   * Tinh luy thua cua 10 voi so mu i-1
   *
   * @param i
   * @return
   */
  static int tinhMu(int i) {
    int mu = 1;
    for (int j = 0; j < i - 1; j++) {
      mu *= 10;
    }
    return mu;
  }

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
      a = m / tinhMu(i);
      m = m - (a * tinhMu(i));
      S += a;
      P *= a;
    }
    System.out.println("Tong: " + S);
    System.out.print("Tich: " + P);

  }


}
