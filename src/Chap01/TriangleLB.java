package Chap01;
import java.util.Scanner;
// 오니쪽 아래가 직각인 이등변 삼각형을 출력합니다.

public class TriangleLB {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int dan;

        System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");

        do {
            System.out.print("몇 단 삼각형입니까? : ");
            dan = stdIn.nextInt();
        } while (dan <= 0);

        for (int i = 0; i < dan; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
