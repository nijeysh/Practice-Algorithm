import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());   // 층 수
        int S = Integer.parseInt(st.nextToken());   // 현재 나의 위치
        int G = Integer.parseInt(st.nextToken());   // 이동해야하는 위치
        int U = Integer.parseInt(st.nextToken());   // UP
        int D = Integer.parseInt(st.nextToken());   // DOWN

        int[] visited = new int[F + 1];
        Queue<Integer> queue = new ArrayDeque();
        Arrays.fill(visited, -1);
        queue.offer(S);
        visited[S] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int distance = visited[current];
            if (current == G) {
                break;
            }

            int up = current + U;
            if (up <= F && visited[up] == -1) {
                queue.offer(up);
                visited[up] = distance + 1;
            }

            int down = current - D;
            if (down > 0 && visited[down] == -1) {
                queue.offer(down);
                visited[down] = distance + 1;
            }
        }

        System.out.println(visited[G] == -1 ? "use the stairs" : visited[G]);
    }
}