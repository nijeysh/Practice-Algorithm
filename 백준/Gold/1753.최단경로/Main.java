import java.io.IOException;
import java.util.*;

public class Main {
    /**
     * 첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다.
     * 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.
     */
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] path;
    static class Node {
        int x;
        int y;
        int distance;
        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public String toString() {
            return "x: " + x + ", y: " + y + ", distance: " + distance;
        }
    }
    public static void main(String[] args) throws IOException {
        int V = read();     // 정점의 개수
        int E = read();     // 간선의 개수
        int K = read();     // 시작 정점의 번호

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = read();
            int v = read();
            int w = read(); // 가중치

            graph[u].add(new Node(u, v, w));
        }

        path = new int[V + 1];
        visited = new boolean[V + 1];
        Arrays.fill(path, -1);
        path[K] = 0;
        bfs(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(path[i] == -1 ? "INF" : path[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int K) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(K);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            // 현재 x 정점, y로 가는 간선
            for (Node node : graph[current]) {
                int next = node.y;

                int distance = path[current] + node.distance;
                if (visited[next]) {
                    path[next] = Math.min(path[next], distance);
                } else {
                    visited[next] = true;
                    path[next] = distance;
                    queue.offer(next);
                }
            }
        }
    }

    static int read() throws IOException {
        int c, n, sign = 1;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n * sign;
    }
}
