import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read(); // 전체 사람 수

        ArrayList<Integer>[] list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList();
        }

        // 촌 수 계산해야하는 사람
        int a = read();
        int b = read();

        // 부모 자식들 간의 관계의 개수
        int m = read();
        for (int i = 0; i < m; i++) {
            int x = read();
            int y = read();

            // 부모 자식 관계
            list[x].add(y);
            list[y].add(x);
        }

        int answer = -1;
        int[] visited = new int[101];
        // a -> b로 가는 가장 최단거리
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(a);
        visited[a] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == b) {
                // System.out.println(visited[node]);
                answer = visited[node] - 1;
                break;
            }

            for (int next : list[node]) {
                if (visited[next] == 0) {
                    visited[next] = visited[node] + 1;
                    queue.offer(next);
                }
            }
        }

        System.out.println(answer);
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