package Chap02;

import java.util.Scanner;

public class prac03 {
    static int sumOf(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();

        int[] a = new int[num];

        for (int i = 0; i < num; i++) {
            a[i] = stdIn.nextInt();
        }

        System.out.println("배열 a의 모든 요소의 합계 : " + sumOf(a));
    }
}
