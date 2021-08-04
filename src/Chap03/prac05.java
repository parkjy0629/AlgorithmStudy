package Chap03;
import java.util.Scanner;
// 이진 검색

public class prac05 {
    static int binSearchX (int[] x, int n, int k) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (x[pc] == k) {
                if (x[pc] == x[pc - 1]) {
                    while (x[pc] == x[pc - 1]) {
                        pc = pc-1;
                    }
                }
                return pc;
            } else if (x[pc] < k) {
                pl = pc + 1;
            } else {
                pr = pc - 1;
            }
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int idx = binSearchX(x, num, key);

        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(key + "의 맨 앞 요소는 x[" + idx + "]에 있습니다.");
        }
    }
}
