package Chap06;
import java.util.Scanner;

public class prac08 {
    static void insertionSort (int[] x, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = x[i];
            int pl = 0;
            int pr = i - 1;
            int pc;
            int pd;

            do {
                pc = (pl + pr) / 2;
                if (x[pc] == tmp)
                    break;
                else if (x[pc] < tmp)
                    pl = pc + 1;
                else
                    pr = pc - 1;
            } while (pl <= pr);
            pd = (pl <= pr) ? pc + 1 : pr + 1;

            for (j = i; j > 0 && x[j - 1] > tmp; j--) {
                x[j] = x[j - 1];
            }
            x[pd] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int n = stdIn.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, n);

        System.out.println("오름차순으로 정렬");
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] : " + x[i]);
        }
    }
}
