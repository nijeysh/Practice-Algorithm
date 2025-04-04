import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();

        int[][] cost = new int[N][3];
        for (int i = 0; i < N; i++) {
            cost[i][0] = read();
            cost[i][1] = read();
            cost[i][2] = read();
        }

        int[][] dp = new int[N][3];

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < N; i++) {
            // red
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);

            // green
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);

            // blue
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
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
