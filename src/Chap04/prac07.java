package Chap04;
// int형 큐

public class prac07 {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] que;

    // 실행 시 예외 : 큐가 비어있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    // 실행 시 예외 : 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {}
    }

    // 생성자
    public prac07(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 덱의 앞에서부터 인큐
    public int enqueFront(int x) throws prac07.OverflowIntQueueException {
        if (num >= max)
            throw new prac07.OverflowIntQueueException();

        num++;

        if (--front < 0)
            front = max - 1;

        que[front] = x;

        return x;
    }

    // 덱의 뒤에서부터 인큐
    public int enqueRear(int x) throws prac07.OverflowIntQueueException {
        if (num >= max)
            throw new prac07.OverflowIntQueueException();

        que[rear++] = x;
        num++;

        if (rear == max)
            rear = 0;

        return x;
    }

    // 덱의 앞에서부터 디큐
    public int dequeFront() throws prac07.EmptyIntQueueException {
        if (num <= 0)
            throw new prac07.EmptyIntQueueException();

        int x = que[front++];
        num--;

        if (front == max)
            front = 0;

        return x;
    }

    // 덱의 뒤에서부터 디큐
    public int dequeRear() throws prac07.EmptyIntQueueException {
        if (num <= 0)
            throw new prac07.EmptyIntQueueException();

        num--;

        if (--rear < 0)
            rear = max - 1;

        return que[rear];
    }

    // 덱의 앞에서부터 피크
    public int peakFront() throws prac07.EmptyIntQueueException {
        if (num <= 0)
            throw new prac07.EmptyIntQueueException();

        return que[front];
    }

    // 덱의 뒤에서부터 피크
    public int peakRear() throws prac07.EmptyIntQueueException {
        if (num <= 0)
            throw new prac07.EmptyIntQueueException();

        return que[rear == 0 ? max - 1 : rear - 1];
    }
    
    // 덱의 x를 검색하여 index(못 찾으면 -1) 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++){
            if (que[(i + front) % max] == x)
                return i + front;
        }
        
        return -1;
    }

    // 덱 비움
    public void clear() {
        num = front = max = 0;
    }

    // 덱의 용량 반환
    public int capacity() {
        return max;
    }

    // 덱에 쌓여 있는 데이터 수 반환
    public int size() {
        return num;
    }

    // 덱이 비어있는가?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 덱이 가득 찼는가?
    public boolean ieFull() {
        return num >= max;
    }

    // 덱 안의 모든 데이터를 프런트->리어 순으로 출력
    public void dump() {
        if (num <= 0) {
            System.out.println("덱이 비어있습니다.");
        }
        else {
            for (int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % max] + " ");
            }
            System.out.println();
        }
    }
}
