import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int edge;
        int distance;
        Node(int edge, int distance) {
            this.edge = edge;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws Exception {
        int N = read(); // 도시 개수
        int M = read(); // 도로 개수
        int K = read(); // 거리
        int X = read(); // 출발 도시

        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int A = read();
            int B = read();
            graph[A].add(B);
        }

        Queue<Node> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        List<Integer> answer = new ArrayList<>();

        // 시작점
        queue.offer(new Node(X, 0));
        visited[X] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.edge;
            int distance = node.distance;

            if (distance == K) {
                answer.add(current);
                continue;
            }

            for (int next : graph[current]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, distance + 1));
                }
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int city : answer) {
                System.out.println(city);
            }
        }
    }

    static int read() throws Exception {
        int c, n = 0, sign = 1;
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
