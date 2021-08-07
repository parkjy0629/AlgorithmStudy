package Chap04;

public class IntAryQueue {
    private int max;        // 큐 용량
    private int num;        // 현재 데이터 수
    private int[] que;      // 큐 본체


    // 실행 시 예외 : 큐가 비어있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    // 실행 시 예외 : 큐가 가득 참
    public class OverflowIntQueueException extends  RuntimeException {
        public OverflowIntQueueException() {}
    }

    // 생성자
    public IntAryQueue(int capacity) {
        num = 0;
        max = capacity;
        try {
            que = new int[max];         // 큐 본체용 배열 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // 큐에 x 인큐
    public int iQue(int x) throws IntStack.OverflowIntStackException {
        if (num >= max)     // 큐가 가득 참
            throw new IntAryQueue.OverflowIntQueueException();
        return que[num++] = x;
    }

    // 큐에서 데이터를 디큐
    public int dQue() throws IntStack.EmptyIntStackException {
        int value = que[0];

        if (num <= 0)       // 큐가 비어있음
            throw  new IntAryQueue.EmptyIntQueueException();

        for (int i = 1; i < num; i++) { // 하나씩 값을 땡김
            que[i - 1] = que[i];
        }

        return value;
    }

    // 큐에서 데이터를 피크
    public int peek() throws IntStack.EmptyIntStackException {
        if (num <= 0)       // 큐가 비어있음
            throw  new IntAryQueue.EmptyIntQueueException();
        return que[0];
    }

    // 큐에서 x를 찾아 인덱스(없으면 -1)를 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            if (que[i] == x)
                return i;           // 검색 성공
        }
        return -1;
    }

    // 큐 비움
    public void clear() {
        num = 0;
    }

    // 큐의 용량 반환
    public int capacity() {
        return max;
    }

    // 큐에 쌓여있는 데이터 수 반환
    public int size() {
        return num;
    }

    // 큐이 비어있는가?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐이 가득 찾는가?
    public boolean isFull() {
        return num >= max;
    }

    // 큐 안의 모든 데이터를 출력
    public void dump() {
        if (num <= 0) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[i] + " ");
            }
            System.out.println();
        }
    }
}
