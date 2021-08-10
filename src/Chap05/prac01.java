package Chap05;

import java.util.Scanner;

public class prac01 {
    static int factorial(int x) {
        int result = 1;
        if (x < 2)
            return 1;
        else {
            for (int i = x; i > 0; i--) {
                result *= i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 fatorial 결과값 : " + factorial(x));
    }
}
