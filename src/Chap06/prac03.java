package Chap06;

import java.util.Scanner;

public class prac03 {
    static void swap (int[] x, int idx1, int idx2) {
        int temp = x[idx1];
        x[idx1] = x[idx2];
        x[idx2] = temp;
    }
    
    static void bubbleSort (int[] x, int n) {
        int compare = 0;
        int swap = 0;

        for (int i = 0; i < n - 1; i++) {
            System.out.println("패스" + (i + 1) + ":");
            int exchg = 0;
            for (int j = n - 1; j > i; j--) {
                compare++;
                for (int k = 0; k < n; k++) {
                    if (k != j - 1) {
                        System.out.printf(x[k] + "\t");
                    } else if (k == j - 1) {
                        if (x[j - 1] > x[j]) {
                            swap++;
                            System.out.print(x[j - 1] + " + " + x[j] + "\t");
                            swap(x, j - 1, j);
                            exchg++;
                            k++;
                        } else if (x[j - 1] <= x[j]) {
                            System.out.print(x[j - 1] + " - ");
                        }
                    }
                }
                System.out.println();
            }
            if (exchg == 0)
                break;
        }

        System.out.println();
        System.out.print("결과 : ");
        for (int i = 0; i < n; i++) {
            System.out.printf(x[i] + "\t");
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
