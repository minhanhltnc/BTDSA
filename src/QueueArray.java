public class QueueArray {
    private int maxSize;
    private int[] arr;
    private int front, rear, count;

    // Khởi tạo queue
    public QueueArray(int size) {
        maxSize = size;
        arr = new int[maxSize];
        front = 0;
        rear = -1;
        count = 0;
    }

    // Thêm phần tử (offer)
    public void offer(int x) {
        if (count == maxSize) {
            System.out.println("Queue đầy, không thể offer " + x);
            return;
        }
        rear = (rear + 1) % maxSize;
        arr[rear] = x;
        count++;
    }

    // Lấy phần tử khỏi queue (poll)
    public int poll() {
        if (count == 0) {
            System.out.println("Queue rỗng, không thể poll");
            return -1;
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        count--;
        return value;
    }

    // Xem phần tử đầu tiên (peek)
    public int peek() {
        if (count == 0) {
            System.out.println("Queue rỗng");
            return -1;
        }
        return arr[front];
    }
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5);

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Peek: " + queue.peek());
        System.out.println("Poll: " + queue.poll());
        System.out.println("Poll: " + queue.poll());

        queue.offer(40);
        queue.offer(50);
        queue.offer(60);
        queue.offer(70); // báo đầy vì size=5

        System.out.println("Peek: " + queue.peek());

        while (queue.count > 0) {
            System.out.println("Poll: " + queue.poll());
        }
    }
}
