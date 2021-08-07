package Chap04;

import java.util.Scanner;

public class prac01 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("스택 용량 : ");
        int capacity = stdIn.nextInt();
        IntStack s = new IntStack(capacity);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());

            System.out.print("(1)push (2)pop (3)peek (4)dump (5)size (6)capacity (0)종료 : ");
            int menu = stdIn.nextInt();

            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1 :        // 푸시
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2 :        // 팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터 : " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 3 :        // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터 : " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 4 :        // 덤프
                    s.dump();
                    break;
                case 5 :
                    System.out.println("stack size : " + s.size());
                    break;
                case 6 :
                    System.out.println("stack capacity : " + s.capacity());
                    break;
            }
        }
    }
}
