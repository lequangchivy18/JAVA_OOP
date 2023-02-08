package assigment_day1_day2;

import java.util.Scanner;

public class Eight {
    /**
     * Tinh tong so duong le cua mang
     *
     * @param a
     * @return
     */
    private static int sumOdd(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 != 0 && a[i] > 0) {
                sum += a[i];
            }
        }
        return sum;
    }

    /**
     * Tim phan tu K
     *
     * @param a
     * @param k
     */
    private static void findK(int[] a, int k) {
        boolean check = false;
        System.out.print("Vi tri: ");
        for (int i = 0; i < a.length; i++) {
            if (k == a[i]) {
                check = true;
                System.out.print(i + " ");
            }
        }
        if (!check) {
            System.out.print("Khong ton tai");
        }
    }

    /**
     * sap xep mang tang dan
     *
     * @param a
     */
    private static void ASC(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        System.out.print("Mang sau khi sap xep: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * Chen mot so P vao mang sao cho mang van dam bao tang dan
     *
     * @param arr ss
     * @param k   ss
     * @return tempArr
     */
    public static int[] insertStr(int[] arr, int k) {
        int arrIndex = arr.length - 1;
        int tempIndex = arr.length;
        int[] tempArr = new int[tempIndex + 1];
        boolean inserted = false;

        for (int i = tempIndex; i >= 0; i--) {
            if (arrIndex > -1 && arr[arrIndex] > k) {
                tempArr[i] = arr[arrIndex--];
            } else {
                if (!inserted) {
                    tempArr[i] = k;
                    inserted = true;
                } else {
                    tempArr[i] = arr[arrIndex--];
                }
            }
        }
        return tempArr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap kich thuoc mang: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu a[" + (i + 1) + "]: ");
            a[i] = sc.nextInt();
        }
        System.out.println("Tong gia tri le: " + sumOdd(a));
        System.out.print("Gia tri can tim kiem: ");
        int k = sc.nextInt();
        findK(a, k);
        System.out.println();
        ASC(a);
        System.out.println();
        System.out.print("Gia tri can chen: ");
        int d = sc.nextInt();
        System.out.print("Mang sau khi chen: ");
        for (int i = 0; i < insertStr(a, d).length; i++) {
            System.out.print(insertStr(a, d)[i] + " ");
        }
    }
}
