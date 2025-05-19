public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();
        // <M:N>이 마지막 해
        for (int i = 0; i < T; i++) {
            int M = read();
            int N = read();
            int x = read() - 1;
            int y = read() - 1;

            int result = -1;
            int lcm = lcm(M, N);

            for (int k = x; k < lcm; k+=M) {
                if (k % N == y) {
                    result = k + 1;
                    break;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    // 최소공배수
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // 최대공약수
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
