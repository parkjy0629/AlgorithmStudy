package Chap06;
import java.util.Scanner;

public class prac09_1 {
    static int shellSort (int[] x, int n) {
        int move = 0;

        for (int h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = x[i];

                for (j = i - h; j >= 0 && x[j] > tmp; j -= h) {
                    x[j + h] = x[j];
                    move++;
                }
                x[j + h] = tmp;
                move++;
            }
        }

        return move;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬(ver.1)");
        System.out.print("요솟수 : ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        int move = shellSort(x, n);

        System.out.println("오름차순 정렬");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] : " + x[i]);
        }
        System.out.println("이동 횟수 : " + move);
    }
}
