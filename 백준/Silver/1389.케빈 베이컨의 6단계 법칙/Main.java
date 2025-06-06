public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        // int INF = Integer.MAX_VALUE;
        int INF = 1_000_000_000;
        int arr[][] = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    arr[i][j] = 0; // 자기 자신으로 가는 경로는 0
                } else {
                    arr[i][j] = INF; // 연결되지 않은 경로는 무한대
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();
            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][k] != INF && arr[k][j] != INF) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                        // arr[j][i] = arr[i][j];
                    }
                }
            }
        }

        int idx = 1;
        int min = INF;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    sum += arr[i][j];
                }
            }
            if (min > sum) {
                idx = i;
                min = sum;
            }
        }

        System.out.println(idx);
        // System.out.println(Arrays.deepToString(arr));
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