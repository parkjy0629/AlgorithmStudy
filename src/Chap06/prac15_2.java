package Chap06;
import Chap04.IntStack;

import java.util.Scanner;
// 퀵 정렬

public class prac15_2 {
    static int sort3Elem(int[] x, int a, int b, int c) {
        if (x[b] < x[a])
            swap(x, b, a);
        if (x[c] < x[b])
            swap(x, c, b);
        if (x[b] < x[a])
            swap(x, b, a);
        return b;
    }

    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void insertionSort(int[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = a[i];
            int j;
            for (j = i; j > 0 && a[j - 1] > tmp; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    static void quickSort (int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();

            if (right - left < 9)
                insertionSort(a, left, right);
            else {
                int x;
                int m = sort3Elem(a, a[pl], a[(left + right) / 2], a[pr]);
                x = a[m];
                swap(a, m, right - 1);
                pl++;
                pr++;

                do {
                    while (a[pl] < x) pl++;
                    while (a[pr] > x) pr--;
                    if (pl <= pr) {
                        swap(a, pl++, pr--);
                    }
                } while (pl <= pr);

                if (pr - left < right - pl) {
                    int temp;
                    temp = left;
                    left = pl;
                    pl = temp;
                    temp = right;
                    right = pr;
                    pr = temp;
                }

                if (left < pr) {
                    lstack.push(left);
                    rstack.push(pr);
                }
                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬(비재귀 버전)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();;
        }

        quickSort(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
