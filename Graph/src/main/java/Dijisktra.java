import java.util.*;

public class Dijisktra {
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        PriorityQueue<Cost> pq = new PriorityQueue<>();
        pq.offer(new Cost(0, s));

        while (!pq.isEmpty()) {
            Cost current = pq.poll();
            int u = current.v;
            int d = current.r;

            if (d > dist[u]) continue;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int w = neighbor[1];
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Cost(dist[v], v));
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            result.add(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int test = 0; test < t; test++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int r = sc.nextInt();
                edges.add(Arrays.asList(x, y, r));
            }

            int s = sc.nextInt();

            List<Integer> result = shortestReach(n, edges, s);
            for (int d : result) {
                System.out.print(d + " ");
            }
            System.out.println();
        }

        sc.close();
    }


}
/**
 * case mẫu
 * 1
 * 4 4
 * 1 2 4
 * 1 4 20
 * 3 1 3
 * 4 3 12
 * 1
 * kq 4 3 15
 */