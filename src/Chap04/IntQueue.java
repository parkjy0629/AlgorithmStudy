package Chap04;
// int형 큐

public class IntQueue {
    private int max;            // 큐의 용량
    private int front;          // 첫 번째 요소 커서
    private int rear;           // 마지막 요소 커서
    private int num;            // 현재 데이터 수
    private int[] que;          // 큐 본체
    
    // 실행 시 예외 : 큐가 비어있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }
    
    // 실행 시 예외 : 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }
    
    // 생성자
    public IntQueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];         // 큐 본체용 배열 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // 큐에 데이터를 인큐
    public int enque(int x) throws OverflowIntQueueException {
        if (num >= max)
            throw new OverflowIntQueueException();      // 큐가 가득참

        que[rear++] = x;
        num++;

        if (rear == max)
            rear = 0;

        return x;
    }

}
