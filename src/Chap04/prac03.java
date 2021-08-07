package Chap04;

import java.util.Scanner;

public class prac03 {
    private int max;
    private int ptrA;
    private int ptrB;
    private int[] stk;

    // 실행 시 예외 : 스택이 비어있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {}
    }

    // 실행 시 예외 : 스택이 가득 참
    public class OverflowIntStackException extends  RuntimeException {
        public OverflowIntStackException() {}
    }

    // 생성자
    public prac03(int capacity) {
        max = capacity;
        ptrA = 0;
        ptrB = max - 1;
        try {
            stk = new int[max];         // 스택 본체용 배열 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // 스택에 x 푸시
    public int push(String s, int x) throws IntStack.OverflowIntStackException {
        if (ptrA >= ptrB - 1)     // 스택이 가득 참
            throw new prac03.OverflowIntStackException();
        switch (s) {
            case "A" :
                stk[ptrA++] = x;
                break;
            case "B" :
                stk[ptrB--] = x;
                break;
        }
        return x;
    }

    // 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄)
    public int pop(String s) throws IntStack.EmptyIntStackException {
        int x = 0;
        switch (s) {
            case "A" :
                if (ptrA <= 0)       // 스택이 비어있음
                    throw  new prac03.EmptyIntStackException();
                x = stk[--ptrA];
                break;
            case "B" :
                if (ptrB >= max - 1)
                    throw new prac03.EmptyIntStackException();
                x = stk[++ptrB];
                break;
        }
        return x;
    }

    // 스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
    public int peek(String s) throws IntStack.EmptyIntStackException {
        int x = 0;
        switch (s) {
            case "A" :
                if (ptrA <= 0)
                    throw new prac03.EmptyIntStackException();
                x = stk[ptrA - 1];
                break;
            case "B" :
                if (ptrB >= max - 1)
                    throw new prac03.EmptyIntStackException();
                x = stk[ptrB + 1];
                break;
        }
        return x;
    }

    // 스택에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(String s, int x) {
        switch (s) {
            case "A" :
                for (int i = ptrA - 1; i >= 0; i--) {
                    if (stk[i] == x)
                        return i;
                }
                return -1;
            case "B" :
                for (int i = ptrB + 1; i < max; i++) {
                    if (stk[i] == x)
                        return i;
                }
                return -1;
        }
        return -1;
    }

    // 스택 비움
    public void clear(String s) {
        switch (s) {
            case "A" :
                ptrA = 0;
                break;
            case "B" :
                ptrB = max - 1;
                break;
        }
    }

    // 스택의 용량 반환
    public int capacity() {
        return max;
    }

    // 스택에 쌓여있는 데이터 수 반환
    public String size() {
        return "StackA : " + ptrA + " / StackB : " + ptrB;
    }

    // 스택이 비어있는가?
    public boolean isEmpty(String s) {
        switch (s) {
            case "A" :
                return ptrA <= 0;
            case "B" :
                return ptrB >= max - 1;
        }
        return true;
    }

    // 스택이 가득 찾는가?
    public boolean isFull(String s) {
        return ptrA >= ptrB + 1;
    }

    // 스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump(String s) {
        switch (s) {
            case "A" :
                if (ptrA <= 0) {
                    System.out.println("스택이 비어있습니다.");
                } else {
                    for (int i = 0; i < ptrA; i++) {
                        System.out.print(stk[i] + " ");
                    }
                    System.out.println();
                }
                break;
            case "B" :
                if (ptrB >= max) {
                    System.out.println("스택이 비어있습니다.");
                } else {
                    for (int i = max - 1; i > ptrB; i--) {
                        System.out.print(stk[i] + " ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
