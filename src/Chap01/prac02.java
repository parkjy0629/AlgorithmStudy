package Chap01;
import java.util.Scanner;

public class prac02 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("n의 값 : ");
        int n = stdIn.nextInt();

        int sum = 0;
        String str = "";

        for (int i = 1; i <= n; i++) {
            sum += i;
            if (i != n) {
                str += (i + " + ");
            } else {
                str += (i + " = ");
            }
        }

        System.out.println(str + sum);
    }
}
