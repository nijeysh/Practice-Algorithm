import java.util.Arrays;
public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        int x = read();

        dp = new int[x+1];
        Arrays.fill(dp, x+1);
        dp[x] = 0;

        dp(x);
        System.out.println(dp[1]);
    }

    static void dp(int x) {
        if (x == 1) {
            return;
        }
        
        if (x % 3 == 0) {
            // Math.max 활용하기
            if ((dp[x] + 1) < dp[x/3]) {
                dp[x/3] = dp[x] + 1;
                dp(x/3);
            }
        }

        if (x % 2 == 0) {
            if (dp[x] + 1 < dp[x/2]) {
                dp[x/2] = dp[x] + 1;
                dp(x/2);
            }
        }

        if (x-1 > 0) {
            if (dp[x] + 1 < dp[x-1]) {
                dp[x-1] = dp[x] + 1;
                dp(x-1);
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