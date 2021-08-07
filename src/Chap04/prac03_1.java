package Chap04;

import java.util.Scanner;

public class prac03_1 {


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("스택 용량 : ");
        int capacity = stdIn.nextInt();
        prac03 s = new prac03(capacity);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " 스택 용량 : " + s.capacity());

            System.out.print("(1)push (2)pop (3)peek (4)dump (5)size (6)capacity (0)종료 : ");
            int menu = stdIn.nextInt();

            if (menu == 0) break;

            int x;
            String str;
            switch (menu) {
                case 1 :        // 푸시
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    System.out.print("StackA or StackB (A/B)?");
                    str = stdIn.next();
                    try {
                        s.push(str, x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2 :        // 팝
                    try {
                        System.out.print("StackA or StackB (A/B)?");
                        str = stdIn.next();
                        x = s.pop(str);
                        System.out.println("팝한 데이터 : " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 3 :        // 피크
                    try {
                        System.out.print("StackA or StackB (A/B)?");
                        str = stdIn.next();
                        x = s.peek(str);
                        System.out.println("피크한 데이터 : " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어있습니다.");
                    }
                    break;
                case 4 :        // 덤프
                    System.out.print("StackA or StackB (A/B)?");
                    str = stdIn.next();
                    s.dump(str);
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
