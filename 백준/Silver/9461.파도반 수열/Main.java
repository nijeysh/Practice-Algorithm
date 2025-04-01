public class Main {
    /**
     * 삼각형이 나선 모양으로 놓여져 있다.
     * 첫 삼각형은 정삼각형으로 변의 길이기 1이다.
     * 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다.
     * 나선에서 가장 긴 변의 길이를 k라 했을 때 그 변에 길이가 k인 정삼각형을 추가한다.
     *
     * P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.
     */
    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp(read())).append("\n");
        }
        System.out.print(sb);
    }

    static long dp(int N) throws Exception {
        long[] P = new long[N + 1];
        P[1] = 1;
        P[2] = 1;
        P[3] = 1;
        for (int i = 4; i <= N; i++) {
            P[i] = P[i - 2] + P[i - 3];
        }

        return P[N];
    }

    static int read() throws Exception {
        int c, n, sign = 1;
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
