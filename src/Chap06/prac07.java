package Chap06;

import java.util.Scanner;

public class prac07 {
    static void insertionSort(int[] x, int n) {
        for (int i = 2; i < n; i++) {
            int tmp = x[0] = x[i];
            int j = i;

            for (; x[j - 1] > tmp; j--) {
                x[j] = x[j - 1];
            }
            if (j > 0) {
                x[j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순삽입정렬 ");
        System.out.print("요솟수：");
        int nx = stdIn.nextInt();
        int[] x = new int[nx + 1];

        for (int i = 1; i <= nx; i++) {
            System.out.print("x[" + i + "]：");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx + 1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 1; i <= nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
