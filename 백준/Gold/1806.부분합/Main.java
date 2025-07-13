public class Main {
    public static void main(String[] args) throws Exception {
        int N = read(); // 10 <= N <= 100_000
        int S = read(); // 0 < S <= 100_000_000
        int INF = Integer.MAX_VALUE;
        // 최소 길이
        // 구간 합
        int[] arr = new int[N];
        int len = INF;
        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }

        int left = 0;
        int cSum = 0;
        for (int right = 0; right < N; right++) {
            cSum += arr[right];
            while (cSum >= S && left <= right) {
                len = Math.min(len, (right-left+1));
                cSum -= arr[left];
                left++;
            }
        }

        System.out.println(len == INF ? 0 : len);
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