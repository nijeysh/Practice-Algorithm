public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        long[][] dp = new long[N + 1][10];
        long mod = 1_000_000_000;

        for (int j = 1; j < 10; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= N; i++) {  // 자릿수
            for (int j = 0; j <= 9; j++) {  // 맨 마지막 수
                if (j == 0) {
                    dp[i][j] = dp[i - 1][1] % mod;
                } else if (j == 9) {
                    dp[i][j] = dp[i - 1][8] % mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long totalCount = 0;
        for (int j = 0; j <= 9; j++) {
            totalCount = (totalCount + dp[N][j]) % mod;
        }
        System.out.println(totalCount);
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