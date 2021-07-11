package Chap01;

public class prac01 {
    // 네 값의 최댓값을 구하는 메서드
    static int max4 (int a, int b, int c, int d) {
        int max = a;

        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;

        return max;
    }

    // 세 값의 최솟값을 구하는 메서드
    static int min3 (int a, int b, int c) {
        int min = a;

        if (b < min) min = b;
        if (c < min) min = c;

        return min;
    }

    // 네 값의 최솟값을 구하는 메서드
    static int min4 (int a, int b, int c, int d) {
        int min = a;

        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;

        return min;
    }

    public static void main(String[] args) {
        System.out.println("max4(1, 5, 2, 9) = " + max4(1, 5, 2, 9));
        System.out.println("min3(5, 8, 2) = " + min3(5, 8, 2));
        System.out.println("min4(2, 7, 9, 1) = " + min4(2, 7, 9, 1));
    }
}