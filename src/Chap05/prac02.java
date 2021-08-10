package Chap05;

import java.util.Scanner;

public class prac02 {
    static int gcd(int x, int y) {
        int temp = 0;

        if (y == 0)
            return x;
        else {
            while (y != 0) {
                temp = x;
                x = y;
                y = temp % y;
            }
        }

        return x;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요 : ");
        int y = stdIn.nextInt();

        System.out.println("두 수의 최대공약수는 : " + gcd(x, y));
    }
}
