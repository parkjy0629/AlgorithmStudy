package Chap05;

import java.util.Scanner;

public class prac03 {
    static int gcd(int x, int y) {
        int temp = 0;

        while (y != 0) {
            temp = x;
            x = y;
            y = temp % y;
        }

        return x;
    }

    static int gcdArray(int[] a, int start, int size) {
        if (size == 1)
            return a[start];
        else if (size == 2)
            return gcd(a[start], a[start + 1]);
        else
            return gcd(a[start], gcdArray(a, start + 1, size - 1));
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 크기 : ");
        int size = stdIn.nextInt();
        int[] a = new int[size];

        int idx = 0;
        do {
            System.out.print("a[" + idx + "] : ");
            a[idx] = stdIn.nextInt();
            idx++;
        } while (idx < size);

        System.out.println("최대공약수는 " + gcdArray(a, 0, size) + "입니다.");
    }
}
