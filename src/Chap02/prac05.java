package Chap02;

import java.util.Scanner;

public class prac05 {
    static void rcopy(int[] a, int[] b){
        for (int i = 0; i < b.length; i++) {
            a[i] = b[b.length - i - 1];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();

        int[] a = new int[num];
        int[] b = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("b[" + i + "] : ");
            b[i] = stdIn.nextInt();
        }

        rcopy(a, b);

        for (int i = 0; i < num; i++) {
            System.out.println("a[" + i + "] : " + a[i] + " / b[" + i + "] : " + b[i]);
        }
    }
}
