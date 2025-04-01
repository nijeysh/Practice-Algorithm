public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(dp(read()));
    }

    static int dp(int N) {
        if (N == 1) return 1;
        if (N == 2) return 2;

        int[] arr = new int[N + 1];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= N; i++) {
            arr[i] = (arr[i - 2]  + arr[i - 1]) % 15746;
        }

        return arr[N];
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