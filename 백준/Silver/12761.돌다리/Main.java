import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    static int A, B, N, M;
    static int[] visited;

    public static void main(String[] args) throws Exception {
        A = read();
        B = read();
        N = read();
        M = read();

        visited = new int[100_001];
        Arrays.fill(visited, -1);
        bfs();
    }

    static void bfs() {
        visited[N] = 0;
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(N);

        int[] next = {+1, -1, +A, -A, +B, -B};
        while (!queue.isEmpty()) {
            int current = queue.poll();     // 현재 위치
            int count = visited[current];    // 이동 횟수

            if (current == M) {
                System.out.println(count);
                return;
            }

            // +1, -1, +A, -A, +B, -B
            for (int i = 0; i < next.length; i++) {
                int target = next[i]+current;
                if (target >= 0 && target < visited.length && visited[target] == -1) {
                    visited[target] = count+1;
                    queue.offer(target);
                }
            }

            // *A, *B
            int nextA = current*A;
            if (nextA >= 0 && nextA < visited.length && visited[nextA] == -1) {
                visited[nextA] = count+1;
                queue.offer(nextA);
            }
            int nextB = current*B;
            if (nextB >= 0 && nextB < visited.length && visited[nextB] == -1) {
                visited[nextB] = count+1;
                queue.offer(nextB);
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