package Chap01;
import java.util.Scanner;

public class prac04 {
    static int sumof(int a, int b) {
        int sum = 0;
        int min = a;

        if (b < min) {
            min = b;
            b = a;
        }

        for (int i = min; i <= b; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] agrs) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("a의 값 : ");
        int a = stdIn.nextInt();
        System.out.print("b의 값 : ");
        int b = stdIn.nextInt();

        System.out.println("sumof(" + a + ", " + b + ")의 합은 " + sumof(a, b) + "입니다.");
    }
}
