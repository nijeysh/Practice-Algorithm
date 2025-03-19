import java.io.*;
import java.util.Arrays;

public class Main {

    static char[][] arr;
    static int[] dx = {0, 1, 1, 2, 2, 2, 2, 2};
    static int[] dy = {0, -1, 1, -2, -1, 0, 1, 2};
    public static void main(String[] args) throws IOException {
        /**
         * 첫째 줄에 N이 주어진다. N은 항상 3×2^k 수이다. (3, 6, 12, 24, 48, ...) (0 ≤ k ≤ 10, k는 정수)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int x = N;
        int y = (2 * N) - 1;
//        int y = (size * 5) + (size - 1);

        arr = new char[x][y];
        for (int i = 0; i < x; i++) {
            Arrays.fill(arr[i], ' ');
        }

        star(0, y / 2, N);

        // char[] 한 줄씩 출력
        for (int i = 0; i < N; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }

        bw.flush();
    }

    static void star(int x, int y, int size) {
        if (size > 3) {
            int h = size / 2;

            // 위
            star(x, y, h);

            // 아래
            star(x + h, y - h, h);
            star(x + h, y + h, h);
            return;
        }

        for (int i = 0; i < 8; i++) {
            arr[x + dx[i]][y + dy[i]] = '*';
        }
    }
}
