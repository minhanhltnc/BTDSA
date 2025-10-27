import java.util.*;

/**
 * Kiểm tra xem chuoi dau ngoac co can bang ko
 * VD {[[((()))]]} là cân bằng
 */
public class BalancedBrackets {
    public String checkBrackets(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.empty()) return "NO";
                char topChar = stack.pop();
                if ((ch == ')' && topChar != '(') ||
                        (ch == ']' && topChar != '[') ||
                        (ch == '}' && topChar != '{')) return "NO";
            }
        }
        return stack.isEmpty() ? "YES" : "NO";

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BalancedBrackets checker = new BalancedBrackets();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String s = scanner.nextLine();
            String result = checker.checkBrackets(s);
            System.out.println(result);
        }
        scanner.close();

    }


    public static class QueueWithTwoStacks {
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

    public static class Sort {
        public static void SelectionSort(int[] a){
            int n=a.length;
            for(int i=0;i<n-1;i++){
                int minIndex=i;
                for(int j=i+1;j<n;j++){
                    if(a[j]<a[i])minIndex=j;
                }
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
        public static void InsertionSort(int[] a) {
            int n = a.length;
            for (int i = 1; i < n; i++) {
                int key = a[i];   // phần tử cần chèn
                int j = i - 1;

                // dịch chuyển các phần tử lớn hơn key sang phải
                while (j >= 0 && a[j] > key) {
                    a[j + 1] = a[j];
                    j--;
                }
                // chèn key vào đúng vị trí
                a[j + 1] = key;
            }
        }
        public static void BubleSort(int[] a){
            int n=a.length;
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1 - i; j++) {
                    if (a[j] > a[j + 1]) {
                        int temp = a[j];
                        a[j] = a[j + 1];
                        a[j + 1] = temp;
                    }
                }
            }
        }

        public static void main(String[] args) {
            int[] arr = {64, 25, 12, 22, 11};

            System.out.println("Mảng ban đầu:");
            for (int num : arr) {
                System.out.print(num + " ");
            }

            SelectionSort(arr);
            //BubleSort(arr);
            //InsertionSort(arr);

            System.out.println("\nMảng sau khi sắp xếp:");
            for (int num : arr) {
                System.out.print(num + " ");
            }

        }
    }

    public static class StackArray {
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
}
