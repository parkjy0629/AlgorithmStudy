package Chap06;

// 단순 삽입 정렬

import java.util.Scanner;

public class InsertionSort {
    // 단순 삽입 정렬
    static void insertionSort (int[] x, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = x[i];

            for (j = i; j > 0 && x[j - 1] > tmp; j--) {
                x[j] = x[j - 1];
            }
            x[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, n);

        System.out.println("오름차순으로 정렬");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] : " + x[i]);
        }
    }
}
