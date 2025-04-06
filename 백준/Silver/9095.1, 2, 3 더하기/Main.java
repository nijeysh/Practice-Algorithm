public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();

        int[] dp = new int[11];
        dp[1] = 1;  // 1
        dp[2] = 2;  // 1+1, 2
        dp[3] = 4;  // 1+1+1, 1+2, 2+1, 3
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[read()]).append("\n");
        }
        System.out.print(sb);
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

