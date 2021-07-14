package Chap01;
import java.util.Scanner;

public class prac11 {
    static void spira (int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = (n - i); j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i - 1) * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void npira (int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = (n - i); j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i - 1) * 2 + 1; j++) {
                System.out.print(i % 10);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("단 : ");
        int dan = stdIn.nextInt();

//        spira(dan);
        npira(dan);
    }
}
