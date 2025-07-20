public class Main {
    public static void main(String[] args) throws Exception {
        // 사자를 배치하는 경우의 수
        // 2 * N
        int N = read(); // 1 <= N <= 100,000

        // 경우의 수 % 9901
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 3;
        // 1개 ->
        for (int i = 2; i <= N; i++) {
            dp[i] = (dp[i-1]*2 + dp[i-2]) % 9901;
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