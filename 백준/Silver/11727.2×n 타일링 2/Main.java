public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        for (int i = 4; i < 1001; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.println(dp[N]);
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