public class Main {
    static int N;
    static int M;
    static int standard;
    static int max;
    static int current;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, 1, -1, -1, 1};
    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = read();
            }
        }


        standard = (N * M) / 4;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                current += arr[i][j];
                backtracking(i, j, 0);
                current -= arr[i][j];
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void backtracking(int row, int col, int depth) throws Exception {
        if (depth == 3) {
            if (max < current) {
                max = current;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
                if (
                        ((nr + 1) < N && visited[nr + 1][nc]) ||
                        ((nr - 1) >= 0 && visited[nr - 1][nc]) ||
                        ((nc + 1) < M && visited[nr][nc + 1]) ||
                        ((nc - 1) >= 0 && visited[nr][nc - 1])
                ) {
                    visited[nr][nc] = true;
                    current += arr[nr][nc];

                    backtracking(nr, nc, depth + 1);

                    current -= arr[nr][nc];
                    visited[nr][nc] = false;
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