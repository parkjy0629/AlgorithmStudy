package Chap02;

public class PrimeNumber2 {
    public static void main(String[] args) {
        int counter = 0;                // 나눗셈 횟수
        int ptr = 0;                    // 찾은 소수의 개수
        int[] prime = new int[500];     // 소수를 저장하는 배열

        prime[ptr++] = 2;               // 2는 소수

        for (int i = 3; i <= 1000; i += 2) {    // 대상은 홀수만
            int n;
            for (n = 1; n < ptr; n++) {     // 이미 찾은 소수로 나누기
                counter++;
                if (i % prime[n] == 0)      // 나누어떨어지면 소수가 아님
                    break;                  // 더 이상의 반복 불필요
            }

            if (ptr == n)                   // 마지막까지 나누어 떨어지지 않음
                prime[ptr++] = i;           // 소수라고 배열에 저장
        }

        for (int i = 0; i < ptr; i++) {     // 찾은 ptr개의 소수를 나타냄
            System.out.println(prime[i]);
        }

        System.out.println("나눗셈을 수행한 횟수 : " + counter);
    }
}