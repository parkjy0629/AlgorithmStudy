package Chap08;
import java.util.Scanner;

public class prac01 {
    static int bfMatch(String txt, String pat) {
        int pt = 0;
        int pp = 0;
        int cnt = 0;
        
        while (pt != txt.length() && pp != pat.length()) {
            cnt++;

            if (pt == (pt - pp)) {
                System.out.print(pt + " ");
            } else {
                System.out.print("  ");
            }
            if (txt.charAt(pt) == pat.charAt(pp)) {
                System.out.println(txt);
                for (int i = 0; i < pt; i++) {
                    System.out.print(" ");
                }
                System.out.println("  +");
                for (int i = 0; i < pt - pp; i++) {
                    System.out.print(" ");
                }
                System.out.println("  " + pat);

                pt++;
                pp++;
            } else {
                System.out.println(txt);
                for (int i = 0; i < pt; i++) {
                    System.out.print(" ");
                }
                System.out.println("  |");
                for (int i = 0; i < pt - pp; i++) {
                    System.out.print(" ");
                }
                System.out.println("  " + pat);

                pt = pt - pp + 1;
                pp = 0;
            }
        }

        if (pp == pat.length()) {       // 검색 성공
            return cnt;
        }
        return -1;                      // 검색 실패
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("패턴 : ");
        String s2 = stdIn.next();

        int cnt = bfMatch(s1, s2);

        System.out.println("비교는 " + cnt + "회였습니다.");
    }
}
