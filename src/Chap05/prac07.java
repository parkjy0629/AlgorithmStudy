package Chap05;

import java.util.Scanner;

public class prac07 {
    static void move(int no, int x, int y) {
        int[] xstk = new int[100];
        int[] ystk = new int[100];
        int[] sstk = new int[100];
        int ptr = 0;
        int sw = 0;

        while (true) {
            if (sw == 0 && no > 1) {
                xstk[ptr] = x;
                ystk[ptr] = y;
                sstk[ptr] = sw;
                ptr++;
                no = no - 1;
                y = 6 - x - y;
                continue;
            }

            System.out.printf("[%d]를 %d기둥에서 %d기둥으로 옮김\n", no, x, y);

            if (sw == 1 && no > 1) {
                xstk[ptr] = x;
                ystk[ptr] = y;
                sstk[ptr] = sw;
                ptr++;
                no = no - 1;
                x = 6 - x - y;
                if (++sw == 2)
                    sw = 0;
                continue;
            }
            do {
                if (ptr-- == 0)
                    return;
                x = xstk[ptr];
                y = ystk[ptr];
                sw = sstk[ptr] + 1;
                no++;
            } while (sw == 2);
        }
    }

    static void move2 (int n, int x, int y) {
        System.out.println("[" + n + "]를 " + x + "기둥에서 " + y + "기둥으로 옮김");
    }

    static void hanoi (int n, int start, int end, int via) {
        if (n == 1)
            move2(1, start, end);
        else {
            hanoi(n-1, start, via, end);
            move2(n, start, end);
            hanoi(n-1, via, end, start);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        move(n, 1, 3);
        System.out.println("========================================");
        hanoi(n, 1, 3, 2);
    }
}
