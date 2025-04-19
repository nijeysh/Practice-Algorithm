import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j + 1] += arr[i][j] + read();
            }
        }

//        System.out.println(Arrays.deepToString(arr));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int x1 = read();
            int y1 = read();
            int x2 = read();
            int y2 = read();
            int sum = 0;
            for (int row = x1; row <= x2; row++) {
                sum += arr[row][y2] - arr[row][y1 - 1];
//                System.out.print(arr[row][y2] - arr[row][y1 - 1]);
//                System.out.print(" + ");
            }
            sb.append(sum).append("\n");
//            System.out.println();
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
