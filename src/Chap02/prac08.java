package Chap02;

import java.util.Scanner;

public class prac08 {
    // 각 달의 일수
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},   // 평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}    // 윤년
    };

    // 서기 year년은 윤년인가? (윤년 : 1 / 평년 : 0)
    static int isLeap(int y) {
        return (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) ? 1 : 0;
    }

    // 서기 y년 m월 d일의 그 해 경과 일 수를 구함
    static int dayOfYear (int y, int m, int d) {
        int month = 1;

        while (month < m) {
            d += mdays[isLeap(y)][month++ - 1];
        }

        return d;
    }

    public static void main (String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int retry;              // 다시 한 번 할 지의 여부

        System.out.println("그 해 경과 일 수를 구합니다.");

        do {
            System.out.print("년 : ");
            int year = stdIn.nextInt();
            System.out.print("월 : ");
            int month = stdIn.nextInt();
            System.out.print("일 : ");
            int day = stdIn.nextInt();

            System.out.printf("그 해 %d일째 입니다.\n", dayOfYear(year, month, day));

            System.out.print("한 번 더 할까요? (1.예 / 0.아니오) : ");
            retry = stdIn.nextInt();
        } while (retry == 1);
    }
}
