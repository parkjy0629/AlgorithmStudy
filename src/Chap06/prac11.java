package Chap06;
import Chap04.IntStack;

import java.util.Scanner;

public class prac11 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort (int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (lstack.isEmpty() != true) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = a[(left + right) / 2];

            System.out.printf("left pop : %d / right pop : %d\n", pl, pr);

            System.out.printf("a[%d] ~ a[%d] : {", left, right);
            for (int i = left; i < right; i++) {
                System.out.printf("%d, ", a[i]);
            }
            System.out.printf("%d}\n", a[right]);

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr) {
                    swap(a, pl++, pr--);
                }
            } while (pl <= pr);

            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
                System.out.printf("left pop : %d / right pop : %d\n", left, pr);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
                System.out.printf("left pop : %d / right pop : %d\n", pl, right);
            }
        }
    }

    static void quickSort (int[] a, int n) {
        quickSort(a, 0, n - 1);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();;
        }

        quickSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
