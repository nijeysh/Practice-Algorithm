public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();
        for (int k = 0; k < T; k++) {
            int n = read(); // 2 x n

            // 배열 세팅
            int[][] arr = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = read();
                }
            }

            System.out.println(sticker(arr, n));
        }
    }

    static int sticker(int[][] arr, int n) {
        // 초기값 세팅

        int[][] dp = new int[3][n];
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];

        for (int i = 1; i < n; i++) {
            // 위쪽 스티커 선택
            // => arr[0][i];
            // 아래쪽 스티커 선택
            // => arr[1][i];

            // 위쪽 스티커를 선택한 값 -> 이전값은 아래쪽 or 선택안함
            dp[0][i] = Math.max(dp[1][i-1], dp[2][i-1]) + arr[0][i];
            // 아래쪽 스티커를 선택한 값 -> 이전값은 위쪽 or 선택안함
            dp[1][i] = Math.max(dp[0][i-1], dp[2][i-1]) + arr[1][i];
            // 현재 열은 아무것도 선택하지 않는다 -> 이전값은 위 or 아래 or 선택안함
            dp[2][i] = Math.max(dp[2][i-1], Math.max(dp[0][i-1], dp[1][i-1]));
        }

        return Math.max(dp[2][n-1], Math.max(dp[0][n-1], dp[1][n-1]));
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