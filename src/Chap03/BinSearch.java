package Chap03;
import java.util.Scanner;
// 이진 검색

public class BinSearch {
    // 요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색
    static int binSearch (int[] x, int n, int k) {
        int pl = 0;             // 검색 범위의 첫 인덱스
        int pr = n - 1;         // 검색 범위의 끝 인덱스

        do {
            int pc = (pl + pr) / 2;     // 중앙 요소 인덱스
            if (x[pc] == k) {
                return pc;          // 검색 성공
            } else if (x[pc] < k) {
                pl = pc + 1;        // 검색 범위를 뒤쪽 절반으로 좁힘
            } else {
                pr = pc - 1;        // 검색 범위를 앞쪽 절반으로 좁힘
            }
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];             // 요솟수가 num인 배열

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");        // 첫 요소 입력
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);      // 바로 앞의 요소보다 작으면 다시 입력
        }

        System.out.print("검색할 값 : ");   // 키 값을 입력
        int key = stdIn.nextInt();

        int idx = binSearch(x, num, key);       // 배열 x에서 키 값이 key 요소를 검색

        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println(key + "운(는) x[" + idx + "]에 있습니다.");
        }
    }
}
