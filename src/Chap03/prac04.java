package Chap03;
import java.util.Scanner;
// 이진 검색

public class prac04 {
    // 요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색
    static int binSearch (int[] x, int n, int k) {
        int pl = 0;
        int pr = n - 1;

        String head = "\t|\t";
        String line = "----+----";
        String value = "";

        for (int i = 0; i < n; i++) {
            head += (i + "\t");
            line += "----";
            value += (x[i] + "\t");
        }
        System.out.println(head);
        System.out.println(line);

        do {
            int pc = (pl + pr) / 2;

            System.out.print("\t|\t");
            for (int i = 0; i < n; i++) {
                if (i == pc)
                    System.out.print("\t+");
                else if (i == pl)
                    System.out.print("<-");
                else if (i == pr)
                    System.out.print("\t->");
                else
                    System.out.print("\t");
            }
            System.out.println();
            System.out.println(pc + "\t|\t" + value);

            if (x[pc] == k) {
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

        int idx = binSearch(x, num, key);

        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(key + "운(는) x[" + idx + "]에 있습니다.");
        }
    }
}
