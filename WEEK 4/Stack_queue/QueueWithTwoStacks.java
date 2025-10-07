import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    public QueueWithTwoStacks() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // Thêm phần tử vào queue
    public void offer(int x) {
        stackIn.push(x);
    }

    // Lấy phần tử đầu tiên khỏi queue
    public int poll() {
        if (isEmpty()) {
            System.out.println("Queue rỗng");
            return -1;
        }
        shiftStacks();
        return stackOut.pop();
    }

    // Xem phần tử đầu tiên
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue rỗng");
            return -1;
        }
        shiftStacks();
        return stackOut.peek();
    }

    // Kiểm tra rỗng
    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // Chuyển dữ liệu từ stackIn sang stackOut nếu cần
    private void shiftStacks() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
    }

    // Hàm main để kiểm thử
    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        System.out.println("Peek: " + queue.peek()); // 10
        System.out.println("Poll: " + queue.poll()); // 10
        System.out.println("Poll: " + queue.poll()); // 20

        queue.offer(40);
        queue.offer(50);

        System.out.println("Peek: " + queue.peek()); // 30

        while (!queue.isEmpty()) {
            System.out.println("Poll: " + queue.poll());
        }
    }
}