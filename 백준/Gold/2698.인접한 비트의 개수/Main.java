public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = read(); // 글자 개수
            int k = read(); // 비트의 개수

            sb.append(find(n, k)).append("\n");
        }

        System.out.print(sb);
    }

    static int find(int n, int k) {
        int[][][] dp = new int[n + 1][2][k + 1];

        // 초기값
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // 끝이 0일 경우
                dp[i][0][j] = dp[i - 1][0][j] + dp[i - 1][1][j];

                // 끝이 1일 경우
                if (j > 0)
                    dp[i][1][j] = dp[i - 1][0][j] + dp[i - 1][1][j - 1];
                else
                    dp[i][1][j] = dp[i - 1][0][j];
            }
        }

        return dp[n][0][k] + dp[n][1][k];
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