package Chap03;

import java.util.Scanner;

public class prac03 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                idx[cnt++] = i;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int n = stdIn.nextInt();

        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] : ");
            a[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int[] idx = new int[n];
        int cnt = searchIdx(a, n, key, idx);

        if (cnt == 0) {
            System.out.println("그 값의 요소가 없습니다.");
        }
        else {
            System.out.print("idx : ");
            for (int i = 0; i < cnt; i++) {
                System.out.print(idx[i] + " ");
            }
            System.out.println("-> " + cnt);
        }
    }
}
