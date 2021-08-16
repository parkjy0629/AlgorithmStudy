package Chap06;

import java.util.Scanner;

public class prac01 {
    static void swap (int[] x, int idx1, int idx2) {
        int temp = x[idx1];
        x[idx1] = x[idx2];
        x[idx2] = temp;
    }

    static void bubbleSort (int[] x, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (x[j] > x[j + 1]) {
                    swap(x, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("오솟수 : ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, n);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] : " + x[i]);
        }
    }
}
