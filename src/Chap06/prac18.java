package Chap06;
import java.util.Scanner;

public class prac18 {
    static void fSort(int[] a, int n, int max) {
        int[] f = new int[max + 1];
        int[] b = new int[n];

        System.out.println("### 1단계 ###");
        for (int i = 0; i < n; i++) {
            f[a[i]]++;

            for (int j = 0; j <= max; j++) {
                System.out.print(f[j] + "\t");
            }
            System.out.println();
        }

        System.out.println("### 2단계 ###");
        for (int i = 1; i <= max; i++) {
            f[i] += f[i - 1];

            for (int j = 0; j <= max; j++) {
                System.out.print(f[j] + "\t");
            }
            System.out.println();
        }

        System.out.println("### 3단계 ###");
        for (int i = n - 1; i >= 0; i--) {
            b[--f[a[i]]] = a[i];

            for (int j = 0; j < n; j++) {
                System.out.print(b[j] + "\t");
            }
            System.out.println();
        }

        System.out.println("### 4단계 ###");
        for (int i = 0; i < n; i++) {
            a[i] = b[i];

            for (int j = 0; j < n; j++) {
                System.out.print(a[j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static void main (String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];
        
        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < 0);
        }
        
        int max = x[0];
        for (int i = 1; i < nx; i++) {
            if (x[i] > max) {
                max = x[i];
            }
        }
        
        fSort(x, nx, max);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }
    }
}
