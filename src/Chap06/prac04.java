package Chap06;

import java.util.Scanner;

public class prac04 {
    static void swap (int[] x, int idx1, int idx2) {
        int temp = x[idx1];
        x[idx1] = x[idx2];
        x[idx2] = temp;
    }
    
    static void bubbleSort (int[] x, int n) {
        int compare = 0;
        int swap = 0;
        int k = 0;
        int i = 0;

        while (k < n - 1) {
            int last = n - 1;

            System.out.println("패스" + (i + 1) + ":");

            for (int j = n - 1; j > k; j--) {
                compare++;
                for (int p = 0; p < n; p++) {
                    if (p != j - 1) {
                        System.out.printf(x[p] + "\t");
                    } else if (p == j - 1) {
                        if (x[j - 1] > x[j]) {
                            swap++;
                            System.out.print(x[j - 1] + " + " + x[j] + "\t");
                            swap(x, j - 1, j);
                            last = j;
                            p++;
                        } else if (x[j - 1] <= x[j]) {
                            System.out.print(x[j - 1] + " - ");
                        }
                    }
                }
                System.out.println();
            }
            k = last;
            i++;
        }

        System.out.println();
        System.out.print("결과 : ");
        for (int j = 0; j < n; j++) {
            System.out.printf(x[j] + "\t");
        }
        System.out.println();
        System.out.println("비교를 " + compare + "회 했습니다.");
        System.out.println("교환을 " + swap + "회 했습니다.");
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
    }
}
