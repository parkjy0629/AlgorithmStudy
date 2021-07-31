package Chap02;

import java.util.Scanner;

public class prac07 {
    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        char temp;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println(r + " |\t\t\t" + x);
        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
            System.out.println("  +-------------");
            if (x == 0) {
                System.out.println("\t\t\t" + x + " ... " + d[digits - 1]);
            } else {
                System.out.println(r + " |\t\t\t" + x + " ... " + d[digits - 1]);
            }
        } while (x != 0);

        for (int i = 0; i < digits / 2; i++) {
            temp = d[i];
            d[i] = d[digits - 1 - i];
            d[digits - 1 - i] = temp;
        }

        return digits;
    }

    public static void main (String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int no;
        int cd;
        int dno;
        char[] cno = new char[32];

        System.out.println("10진수를 기수 변환합니다.");
        do {
            System.out.print("변환하는 음이 아닌 정수 : ");
            no = stdIn.nextInt();
        } while (no < 0);

        do {
            System.out.print("어떤 진수로 변환할까요? (2~36) : ");
            cd = stdIn.nextInt();
        } while (cd < 2 || cd > 36);

        dno = cardConv(no, cd, cno);

        System.out.print(cd + "진수로는 ");
        for (int i = 0; i < dno - 1; i++) {
            System.out.print(cno[i]);
        }
        System.out.println("입니다.");
    }
}
