package assigment_day1_day2;

import java.util.Scanner;

public class Nine {
    /**
     * Tich cac boi so cua 3 nam tren dong dau tien cua ma tran
     *
     * @param matrix
     * @param n
     * @return
     */
    private static int multiThree(int[][] matrix, int n) {
        int tich = 1;
        for (int j = 0, i = 0; j < n; j++) {
            if (matrix[i][j] % 3 == 0) {
                tich *= matrix[i][j];
            }
        }
        if (tich < 3) {
            tich = 0;
        }
        return tich;
    }

    /**
     * Tao mang chua cac phan tu max tren moi hang cua ma tran
     *
     * @param matrix
     * @param x
     * @param m
     * @param n
     */
    private static void insertMax(int[][] matrix, int[] x, int m, int n) {
        int max;
        for (int i = 0; i < m; i++) {
            max = matrix[i][0];
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            x[i] = max;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap m-n: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.print("Ma tran: ");
        for (int i = 0; i < m; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
        System.out.print("\nTich cac boi so cua 3 o dong dau tien: " + multiThree(matrix, n));
        int[] X = new int[m];
        System.out.println();
        insertMax(matrix, X, m, n);
        System.out.print("Mang max: ");
        for (int i = 0; i < X.length; i++) {
            System.out.print(X[i] + " ");
        }
    }
}
