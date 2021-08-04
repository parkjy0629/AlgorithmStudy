package Chap03;

// 선형 검색 (보초법)

import java.util.Scanner;

public class prac02 {
    // 요솟수가 n인 배열 a에서 key와 같은 요소를 보초법으로 선형 검색
    static int seqSearchSen (int[] x, int n, int k) {
        int i = 0;

        x[n] = k;

        String head = "\t|\t";
        String line = "----+----";
        String value = "";

        for (i = 0; i < n; i++) {
            head += (i + "\t");
            line += "----";
            value += (x[i] + "\t");
        }
        System.out.println(head);
        System.out.println(line);

        for (i = 0; i < n; i++) {
            String idx = "\t|\t";

            for (int j = 0; j < i; j++) {
                idx += "\t";
            } idx += "*";
            System.out.println(idx);

            System.out.println(i + "\t|\t" + value);
            System.out.println("\t|\t");

            if (x[i] == k)
                break;

        }

        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];         // 요솟수 num + 1

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");           // 키 값을 입력
        int key = stdIn.nextInt();

        int idx = seqSearchSen(x, num, key);        // 배열 x에서 값이 key인 요소를 검색

        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
        }
    }
}
