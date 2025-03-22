import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    /**
     * 방향성이 없는 그래프가 주어진다.
     * 세준이는 1번 정점에서 N번 정점으로 최단 거리로 이동하려고 한다.
     *
     * 또한 세준이는 두 가지 조건을 만족하면서 이동하는 특정한 최단 경로를 구하고 싶은데, 그것은 바로 임의로 주어진 두 정점은 반드시 통과해야 한다는 것이다.
     * 세준이는 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 하지만 반드시 최단 경로로 이동해야 한다는 사실에 주의하라.
     * 1번 정점에서 N번 정점으로 이동할 때, 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성하시오.
     */
    static ArrayList<Node>[] graph;
    static int INF = 200_000_000;
    static int N, E;
    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }

    }
    public static void main(String[] args) throws IOException {
        N = read(); // 정점의 개수
        E = read(); // 간선의 개수

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int a = read();
            int b = read();
            int c = read();

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        int v1 = read();
        int v2 = read();

        // 1 -> v1, v1 -> v2, v2 -> N
        // 1 -> v2, v2 -> v1, v1 -> N
        int min1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int min2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        if (min1 >= INF && min2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(min1, min2));
        }
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];

        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            for (Node next : graph[currentVertex]) {
                int nextVertex = next.vertex;
                int nextDistance = distance[currentVertex] + next.distance;

                if (nextDistance < distance[nextVertex]) {
                    distance[nextVertex] = nextDistance;
                    pq.offer(new Node(nextVertex, nextDistance));
                }
            }
        }

        return distance[end];
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