import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws Exception {
        N = read(); // 컴퓨터 수
        M = read(); // 신뢰 관계 수

        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = read();
            int b = read();
            // a가 b를 신뢰하면 b를 해킹하면 a도 해킹 가능 -> 역방향 저장
            list[b].add(a);
        }

        visited = new boolean[N + 1]; // 한 번만 생성
        int max = 0;
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            int count = bfs(i);
            result[i] = count;
            max = Math.max(max, count);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.print(sb.toString());
    }

    static int bfs(int start) {
        // 연결이 없으면 자신만 해킹 가능
        if (list[start].isEmpty()) return 1;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        int count = 1; // 자신 포함
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : list[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }
        return count;
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