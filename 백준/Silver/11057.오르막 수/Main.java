import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        // 수의 길이 N
        // 1; 1, 2, 3, ..., 9
        // 2; 11, 12, .. 19, 22, ..29, 33, .. 39, 44, .., 49, 55, .. 59, 66, ..., 69, 99
        // 3; 
        long[][] dp = new long[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        if (N == 1) {
            System.out.println(10);
            return;
        }
        // System.out.println(Arrays.deepToString(dp));
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                long sum = 0;
                for (int k = j; k < 10; k++) {
                    sum += dp[i - 1][k];
                    sum %= 10007;
                    // System.out.println(sum);
                }
                dp[i][j] = sum;
//                if (i == N) {
//                    System.out.println("dp: " + dp[i - 1][0] % 10007);

//                    System.out.println(sum);
//                }
            }
        }

        // System.out.println(Arrays.deepToString(dp));

         long sum = 0;
         for (int i = 0; i < 10; i++) {
             sum += dp[N][i];
             // System.out.println(dp[N][i]);
         }
         System.out.println(sum % 10007);
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