package Chap01;
import java.util.Scanner;

public class prac10 {
    // 왼쪽 아래가 직각인 이등변 삼각형을 출력
    static void triangleLB (int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 왼쪽 위가 직각인 이등변 삼각형을 출력
    static void triangleLU (int n) {
        for (int i = 0; i < n; i++) {
            for (int j = (n - i); j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 오른쪽 위가 직각인 이등변 삼각형을 출력
    static void triangleRU (int n) {
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < i; x++) {
                System.out.print(" ");
            }
            for (int j = (n - i); j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // 오른쪽 아래가 직각인 이등변 삼각형을 출력
    static void triangleRB (int n) {
        for (int i = 0; i < n; i++) {
            for (int x = 0; x < (n - i - 1); x++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int dan;

        do {
            System.out.print("몇 단 삼각형입니까? : ");
            dan = stdIn.nextInt();
        } while (dan <= 0);

//        triangleLB(dan);
//        triangleLU(dan);
//        triangleRU(dan);
        triangleRB(dan);
    }
}
