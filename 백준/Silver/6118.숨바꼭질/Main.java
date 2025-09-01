import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Queue<Barn> queue = new ArrayDeque();
    static class Barn {
        int node;
        int distance;
        Barn(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // 어떤 헛간에서 다른 헛간으로 언제나 도달 가능하다.
    // 1에서 가장 먼 헛간을 찾는다.
    public static void main(String[] args) throws Exception {
        int N = read(); // 헛간의 개수
        int M = read(); // M개의 양방향 길
        graph = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList();
        }

        for (int i = 0; i < M; i++) {
            int a = read();
            int b = read();

            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N+1];
        bfs(1);
    }

    static void bfs(int start) {
        visited[start] = true;
        queue.offer(new Barn(start, 0));

        int num = 1; // 숨어야하는 헛간 번호
        int max = 0; // 헛간까지의 거리
        int cnt = 1; // max 헛간과 같은 거리를 갖는 헛간의 개수

        while (!queue.isEmpty()) {
            Barn current = queue.poll();
            int node = current.node;
            int distance = current.distance;

            if (distance > max) {
                num = node;
                max = distance;
                cnt = 1;
            } else if (distance == max) {
                num = Math.min(node, num);
                cnt++;
            }

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new Barn(next, distance+1));
                }
            }
        }

        System.out.println(num + " " + max + " " + cnt);
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