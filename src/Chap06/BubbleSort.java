package Chap06;

import java.util.Scanner;

// 버블 정렬(Ver.1)
public class BubbleSort {
    // x[idx1] <-> x[idx2] 값 변경
    static void swap (int[] x, int idx1, int idx2) {
        int temp = x[idx1];
        x[idx1] = x[idx2];
        x[idx2] = temp;
    }
    // 버블 정렬
    static void bubbleSort (int[] x, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (x[j - 1] > x[j]) {
                    swap(x, j - 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
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
