import java.util.*;

/**
 * Prim- tìm cây khung nhỏ nhất, chưa có truy vết
 */

public class Prim {
    public static int prims(int n, List<List<Integer>> edges, int start){
        //xây danh sách kề từ danh sách cạnh
        Map<Integer,List<Cost>> graph= new HashMap<>();
        for (int i = 1; i <= n; i++) graph.put(i, new ArrayList<>());

        for(List<Integer> edge :edges){
            int u=edge.get(0);int v=edge.get(1);int w=edge.get(2);
            graph.get(u).add(new Cost(w, v));
            graph.get(v).add(new Cost(w, u));
        }
        //Bước 2: Khởi tạo thuật toán Prim
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Cost> pq = new PriorityQueue<>();
        pq.add(new Cost(0, start));
        int total = 0;
        // Bước 3: Duyệt cây khung nhỏ nhất
        while (!pq.isEmpty()) {
            Cost cur = pq.poll();
            int u = cur.v;
            if (visited[u]) continue;
            visited[u] = true;
            total += cur.r;

            for (Cost neighbor : graph.get(u)) {
                if (!visited[neighbor.v]) {
                    pq.add(new Cost(neighbor.r, neighbor.v));
                }
            }
        }

        return total;
    }
    public static void main(String[] args) {
        int n = 5; // số đỉnh
        int start = 1; // đỉnh bắt đầu

        // Danh sách cạnh: mỗi phần tử là [u, v, w]
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2, 3));
        edges.add(Arrays.asList(1, 3, 4));
        edges.add(Arrays.asList(4, 2, 6));
        edges.add(Arrays.asList(5, 2, 2));
        edges.add(Arrays.asList(2, 3, 5));
        edges.add(Arrays.asList(3, 5, 7));

        int result = Prim.prims(n, edges, start);
        System.out.println("Tổng trọng số cây khung nhỏ nhất: " + result);
    }




}
