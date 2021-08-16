package Chap06;
// 셸 정렬(Ver.2, h의 값은 ..., 40, 13, 4, 1)

import java.util.Scanner;

public class ShellSort2 {
    // 셸 정렬
    static void shellSort (int[] x, int n) {
        int h;
        for (h = 1; h < n / 9; h = h * 3 + 1);

        for ( ; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = x[i];

                for (j = i - h; j >= 0 && x[j] > tmp; j -= h) {
                    x[j + h] = x[j];
                }
                x[j + h] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬(Ver.2)");
        System.out.print("요솟수 : ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        shellSort(x, n);

        System.out.println("오름차순 정렬");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] : " + x[i]);
        }
    }
}
