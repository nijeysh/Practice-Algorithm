import java.util.Arrays;

public class Main {

    static int N;
    static int[][] arr;
    static int[] count = new int[3];;

    public static void main(String[] args) throws Exception {
        N = read();

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = read();
            }
        }
        // System.out.println(Arrays.deepToString(arr));

        dfs(0, 0, N);

        System.out.println(count[0]);
        System.out.println(count[1]);
        System.out.println(count[2]);
    }

    static void dfs(int row, int col, int size) {
        boolean continuous = true;
        int standard = arr[row][col];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (arr[row + i][col + j] != standard) {
                    continuous = false;
                    break;
                }
            }
            if (!continuous) {
                break;
            }
        }

        if (continuous) {
            count[standard + 1] += 1;
            // System.out.println("row: " + row + ", col: " + col + ", size: " + size);
        } else {
            int piece = size / 3;
            for (int i = row; i < row+size; i+=piece) {
                for (int j = col; j < col+size; j+=piece) {
                    dfs(i, j, piece);
                }
            }
        }
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