import java.util.*;

public class JesseandCookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // số lượng bánh
        int K = scanner.nextInt(); // độ ngọt

        // hàng đợi ưu tiên trong java mặc định kiểu min-PQ
        PriorityQueue<Integer> pqueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pqueue.add(scanner.nextInt());
        }

        int count = 0;

        while (pqueue.size() >= 2 && pqueue.peek() < K) {
            int m1 = pqueue.poll();   // bánh ít ngọt nhất
            int m2 = pqueue.poll();   // bánh ít ngọt thứ hai
            int mixed = m1 + 2 * m2;  // bánh mới
            pqueue.add(mixed);
            count++;
        }

        // Kiểm tra
        if (!pqueue.isEmpty() && pqueue.peek() >= K) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }
}
