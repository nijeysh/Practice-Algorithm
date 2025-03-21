import java.io.IOException;
import java.util.*;
public class Main {
    /**
     * 첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다.
     * 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.
     */
    static ArrayList<Node>[] graph;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int vertex;      // 정점
        int distance;    // 시작점에서부터의 거리

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
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
            int u = read();    // 출발 정점
            int v = read();    // 도착 정점
            int w = read();    // 가중치
            graph[u].add(new Node(v, w));
        }

        // 다익스트라 알고리즘 수행
        distance = new int[V + 1];
        Arrays.fill(distance, INF);
        dijkstra(K);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == INF ? "INF" : distance[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[distance.length];

        // 시작 노드 초기화
        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            // 이미 처리된 노드라면 건너뛰기
            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            // 현재 노드와 연결된 다른 노드들 확인
            for (Node next : graph[currentVertex]) {
                int nextVertex = next.vertex;
                int nextDistance = distance[currentVertex] + next.distance;

                // 현재까지 알려진 경로보다 더 짧은 경로를 발견한 경우 업데이트
                if (nextDistance < distance[nextVertex]) {
                    distance[nextVertex] = nextDistance;
                    pq.offer(new Node(nextVertex, nextDistance));
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