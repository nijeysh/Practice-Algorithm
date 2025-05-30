import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Queue;
import java.util.ArrayDeque;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int startX = 0;
        int startY = 0;
        char[][] campus = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    startX = i;
                    startY = j;
                }
            }
        }

        // System.out.println("campus: " + Arrays.deepToString(campus));
        // System.out.println("startX: " + startX);
        // System.out.println("startY: " + startY);

        int count = 0;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();

        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY});
        // int[] current = queue.poll();
        // System.out.println(current[0]);
        // System.out.println(current[1]);
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 4; i++) {
                int cx = dx[i] + currentX;
                int cy = dy[i] + currentY;
                if (cx >= 0 && cx < N && cy >= 0 && cy < M
                        && campus[cx][cy] != 'X' && !visited[cx][cy]) {

                    // System.out.println("cx: " + cx + ", cy: " + cy + ", val: " + campus[cx][cy]);
                    visited[cx][cy] = true;
                    queue.offer(new int[]{cx, cy});
                    if (campus[cx][cy] == 'P') {
                        count++;
                    }
                }
            }
        }

        System.out.println(count == 0 ? "TT" : count);
    }
}