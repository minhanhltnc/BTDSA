public class StackArray {
    private int maxSize;
    private int[] arr;
    private int top;

    // Khởi tạo stack
    public StackArray(int size) {
        maxSize = size;
        arr = new int[maxSize];
        top = -1; // stack rỗng
    }

    // Thêm phần tử vào stack (push)
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack đầy, không thể push " + x);
            return;
        }
        arr[++top] = x;
    }

    // Lấy phần tử trên cùng ra khỏi stack (pop)
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack rỗng, không thể pop");
            return -1;
        }
        return arr[top--];
    }

    // Xem phần tử trên cùng (peek)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack rỗng");
            return -1;
        }
        return arr[top];
    }

    // Kiểm tra rỗng
    public boolean isEmpty() {
        return top == -1;
    }

    // Kiểm tra đầy
    public boolean isFull() {
        return top == maxSize - 1;
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Phần tử trên cùng: " + stack.peek()); // 30

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);

        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop());
        }
    }
}
