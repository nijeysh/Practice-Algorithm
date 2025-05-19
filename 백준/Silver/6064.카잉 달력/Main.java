public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();
        // <M:N>이 마지막 해
        for (int i = 0; i < T; i++) {
            int M = read();
            int N = read();
            int x = read();
            int y = read();

            int result = -1;
            for (int k = x; k <= M * N; k+=M) {
                int currentY = (k % N) == 0 ? N : k % N;
                if (currentY == y) {
                    result = k;
                    break;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
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
