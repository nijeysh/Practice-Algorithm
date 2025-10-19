import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read(); // 참여하는 사람의 수
        int K = read(); // 보성이의 번호

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();    // 지목한 사람의 번호
        }

        Queue<Integer> queue = new ArrayDeque();
        boolean[] visited = new boolean[N];
        visited[0] = true;
        queue.offer(0);

        int answer = 0;
        int distance = 1;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int next = arr[current];

            if (visited[next]) {
                answer = -1;
                break;
            }
            if (next == K) {
                answer = distance;
                break;
            }

            visited[next] = true;
            queue.offer(next);
            distance++;
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