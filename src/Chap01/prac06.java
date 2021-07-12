package Chap01;
import java.util.Scanner;

public class prac06 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        do {
            System.out.print("양의 정수 : ");
            n = stdIn.nextInt();
        } while (n < 1);

        int i = 0;
        while (n > 0) {
            n = n / 10;
            i++;
        }

        System.out.println("그 수는 " + i + "자리입니다.");
    }
}
