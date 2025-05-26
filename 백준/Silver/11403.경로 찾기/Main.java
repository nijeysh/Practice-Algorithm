import java.io.IOException; // IOException 필요
import java.util.LinkedList; // LinkedList (Queue 구현체) 필요
import java.util.Queue;     // Queue 인터페이스 필요

public class Main {
    static int N;
    static int[][] graph;
    static int[][] result;

    public static void main(String[] args) throws IOException {
        N = read();

        graph = new int[N][N];
        result = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = read();
            }
        }

        for (int i = 0; i < N; i++) {
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode = 0; nextNode < N; nextNode++) {
                if (graph[currentNode][nextNode] == 1 && !visited[nextNode]) {
                    visited[nextNode] = true;
                    result[startNode][nextNode] = 1;
                    queue.offer(nextNode);
                }
            }
        }
    }

    static int read() throws IOException {
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