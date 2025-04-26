import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
    /**
     * (2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
     */
    static class Land {
        int row;
        int col;
        int distance;

        Land(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    static Queue<Land> queue = new ArrayDeque<>();
    static int[][] visited;
    static int[][] arr;
    static Land target;

    static int n;
    static int m;
    public static void main(String[] args) throws Exception {
        n = read();     // 세로
        m = read();     // 가로

        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = read();
                if (arr[i][j] == 2) {
                    target = new Land(i, j, 0);
                }
            }
        }

        visited = new int[n][m];
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(visited[i][j]);
                if (j < m - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void bfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    visited[i][j] = 0;
                } else {
                    visited[i][j] = -1;
                }
            }
        }

        visited[target.row][target.col] = 0;
        queue.add(target);

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            Land current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dr = current.row + dx[i];
                int dc = current.col + dy[i];

                // 범위 내에 있고, 갈 수 있는 땅이며, 아직 방문하지 않았다면
                if (dr >= 0 && dr < n && dc >= 0 && dc < m && arr[dr][dc] == 1 && visited[dr][dc] == -1) {
                    visited[dr][dc] = current.distance + 1;
                    queue.add(new Land(dr, dc, current.distance + 1));
                }
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
