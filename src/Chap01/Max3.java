package Chap01;
import java.util.Scanner;

public class Max3 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최댓값을 구합니다.");
        System.out.print("a의 값 : ");
        int a = stdIn.nextInt();
        System.out.print("b의 값 : ");
        int b = stdIn.nextInt();
        System.out.print("c의 값 : ");
        int c = stdIn.nextInt();

        // a, b, c의 최댓값을 구해 max에 대입
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;

        System.out.println("최댓값은" + max + "입니다.");
    }
}