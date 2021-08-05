package Chap03;
import java.util.Arrays;
import java.util.Scanner;
// Arrays.BinarySearch로 이진 검색

public class prac06 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];         // 요솟수가 num인 배열

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");    // 배열의 첫 요소를 먼저 입력
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);
        }

        System.out.print("검색할 값 : ");
        int key = stdIn.nextInt();

        int idx = Arrays.binarySearch(x, key);      // 배열 x에서 키 값이 key인 요소를 검색

        if (idx < 0) {
            System.out.println("검색 실패!! 삽입 포인트 : " + Math.abs(idx));
        } else {
            System.out.println(key + "은(는) x[" + idx + "]에 있습니다.");
        }
    }
}
