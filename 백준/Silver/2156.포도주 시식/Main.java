import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }

        if (N == 1) {
            System.out.println(arr[0]);
            return;
        }

        if (N == 2) {
            System.out.println(arr[1] + arr[0]);
            return;
        }

        int[][] dp = new int[N][3];
        dp[0][0] = arr[0];
        dp[0][1] = arr[0];
        dp[0][2] = 0;
        dp[1][0] = arr[1] + arr[0];
        dp[1][1] = arr[1];
        dp[1][2] = arr[0];
        for (int i = 2; i < N; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 2][0], dp[i - 1][2])) + arr[i];
            dp[i][1] = Math.max(dp[i - 2][0], Math.max(dp[i - 2][1], dp[i - 2][2])) + arr[i];
            dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
        }

        System.out.println(Math.max(dp[N - 1][1], Math.max(dp[N - 1][0], dp[N - 1][2])));
        // System.out.println(Arrays.deepToString(dp));
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

