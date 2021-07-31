package Chap02;

public class PrimeNumber1 {
    public static void main(String[] args) {
        int counter = 0;            // 나눗셈의 횟수

        for (int i = 2; i <= 1000; i++) {
            int n;
            for (n = 2; n < i; n++) {
                counter++;
                if (i % n == 0)     // 나누어 떨어지면 소수가 아님
                    break;          // 더 이상의 반복은 불필요
            }

            if (i == n) {   // 마지막까지 나누어떨어지지 않음
                System.out.println(i);
            }
        }

        System.out.println("나눈셈을 수행한 횟수 : " + counter);
    }
}
