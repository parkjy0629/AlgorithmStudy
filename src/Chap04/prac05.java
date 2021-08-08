package Chap04;

public class prac05 {
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
    public prac05(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];         // 큐 본체용 배열 생성
        } catch (OutOfMemoryError e) {  // 생성할 수 없음
            max = 0;
        }
    }

    // 임의의 데이터 검색 (해당 데이터가 몇번째 데이터인지 / 인덱스 X)
    public int search(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x) {
                return idx + 1;
            }
        }
        return -1;
    }
}
