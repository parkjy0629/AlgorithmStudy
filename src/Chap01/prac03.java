package Chap01;
import java.util.Scanner;

public class prac03 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("n의 값 : ");
        int n = stdIn.nextInt();

        int sum = (1 + n)*(n / 2);

        if (n % 2 != 0) {
            sum += (n / 2) + 1;
        }

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
    }
}
