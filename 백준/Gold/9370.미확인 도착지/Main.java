import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    static ArrayList<Node>[] graph;
    static int n;
    static int INF = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        int T = read();
        for (int i = 0; i < T; i++) {
            n = read();     // 교차로 (정점의 개수)
            int m = read();     // 도로
            int t = read();     // 목적지 후보의 개수

            int s = read();     // 출발지
            int g = read();     // g - h
            int h = read();     // h - g

            graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                int a = read();     // 정점
                int b = read();     // 간선 (양방향)
                int d = read();     // 길이

                graph[a].add(new Node(b, d));
                graph[b].add(new Node(a, d));
            }

            // s - g - h - x
            int path1 = dijkstra(s, g) + dijkstra(g, h);

            // s - h - g - x
            int path2 = dijkstra(s, h) + dijkstra(h, g);

            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < t; j++) {
                int x = read();     // 목적지 후보 (x != s)
                int min = dijkstra(s, x);


                if (path1 + dijkstra(h, x) == min || path2 + dijkstra(g, x) == min) {
                    arr.add(x);
                }
            }

            // 결과
            Collections.sort(arr);
            for (int j = 0; j < arr.size(); j++) {
                sb.append(arr.get(j));
                if (j != arr.size() - 1) {
                    sb.append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    static int dijkstra(int st, int en) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] cost = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(cost, INF);
        cost[st] = 0;
        pq.offer(new Node(st, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            for (Node next : graph[currentVertex]) {
                int nextVertex = next.vertex;
                int nextDistance = current.distance + next.distance;

                if (cost[nextVertex] > nextDistance) {
                    cost[nextVertex] = nextDistance;
                    pq.offer(new Node(nextVertex, nextDistance));
                }
            }
        }

        return cost[en];
    }

    static int read() throws IOException {
        int c, n, sign = 1;
        while((c = System.in.read()) <= 32);
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        n = c & 15;
        while((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n * sign;
    }
}
