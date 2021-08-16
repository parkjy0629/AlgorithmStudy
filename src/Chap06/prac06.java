package Chap06;

import java.util.Scanner;

public class prac06 {
    static void swap (int[] x, int idx1, int idx2) {
        int temp = x[idx1];
        x[idx1] = x[idx2];
        x[idx2] = temp;
    }
    
    static void selectionSort (int[] x, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;

            for (int j = 0; j < i; j++) {
                System.out.printf("\t");
            }
            System.out.printf("*" + "\t");

            for (int j = i + 1; j < n; j++) {
                if (x[j] < x[min]) {
                    min = j;
                }
            }

            for (int j = i; j < min - 1; j++) {
                System.out.print("\t");
            }
            System.out.println("+");

            for (int j = 0; j < n; j++) {
                System.out.printf(x[j] + "\t");
            }
            System.out.println();
            swap(x, i, min);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("오솟수 : ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, n);

        System.out.println("오름차순으로 정렬");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] : " + x[i]);
        }
    }
}
