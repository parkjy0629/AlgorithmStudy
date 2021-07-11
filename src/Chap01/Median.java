package Chap01;
import java.util.Scanner;
// 3개의 정수값을 입력하고 중앙값을 구한 다음 출력합니다.

public class Median {
    static int med3(int a, int b, int c) {
        if (a >= b) {
            if (b >= c)
                return b;
            else if (a <= c)
                return a;
            else
                return c;
        } else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;
    }

    static int med3_2(int a, int b, int c) {
        if ((b >= a && c <= a) || (b <= a && c >= a))
            return a;
        else if ((b < a && c < b) || (b > a && c > b))
            return b;
        else
            return c;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 중앙값을 구합니다.");

        System.out.print("a의 값 : ");
        int a = stdIn.nextInt();
        System.out.print("b의 값 : ");
        int b = stdIn.nextInt();
        System.out.print("c의 값 : ");
        int c = stdIn.nextInt();

        System.out.println("중앙값은 " + med3(a, b, c) + "입니다.");
    }
}