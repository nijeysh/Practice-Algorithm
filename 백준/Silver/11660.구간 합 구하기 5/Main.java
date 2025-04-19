import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = read() + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }

        System.out.println(Arrays.deepToString(arr));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int x1 = read();
            int y1 = read();
            int x2 = read();
            int y2 = read();
            int sum = arr[x2][y2] - arr[x2][y1-1] - arr[x1-1][y2] + arr[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }

    static int read() throws Exception{
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
