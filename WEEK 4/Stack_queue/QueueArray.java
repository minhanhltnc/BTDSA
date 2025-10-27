public class QueueArray {
    private int maxSize;
    private int[] arr;
    private int head, tail;

    public QueueArray(int size) {
        maxSize = size;
        arr = new int[maxSize];
        head = 0;
        tail = -1;
    }

    public boolean offer(int x) {
        if (isFull()) return false;
        tail++;
        arr[tail] = x;
        return true;
    }

    public int poll() {
        if (isEmpty()) return -1;
        int value = arr[head];
        head++;
        return value;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return arr[head];
    }

    public boolean isEmpty() {
        return head > tail;
    }

    public boolean isFull() {
        return tail == maxSize - 1;
    }

    public int size() {
        return isEmpty() ? 0 : tail - head + 1;
    }
}