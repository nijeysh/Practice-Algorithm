import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int T = read();
        while (T-- > 0) {
            int N = read();
            int[] all = new int[N];
            for (int i = 0; i < N; i++) all[i] = read();
            Arrays.sort(all);

            int M = read();
            for (int i = 0; i < M; i++) {
                int q = read();
                sb.append(Arrays.binarySearch(all, q) >= 0 ? "1\n" : "0\n");
            }
        }
        System.out.print(sb.toString());
    }

    static int read() throws Exception {
        int c;
        while ((c = System.in.read()) <= 32);
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        int n = c - '0';
        while ((c = System.in.read()) > 32) n = n * 10 + (c - '0');
        return n * sign;
    }
}
