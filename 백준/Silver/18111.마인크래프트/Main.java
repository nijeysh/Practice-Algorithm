import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int B;

    static int max;
    static int min;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        // 1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. (2초)
        // 2. 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. (1초)

        N = read(); // 세로
        M = read(); // 가로
        B = read(); // 인벤토리에 있는 블록

        arr = new int[N][M];

        // 땅 입력 받기
        max = 0;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = read();
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int minT = Integer.MAX_VALUE;
        int maxH = 0;

        for (int h = 0; h <= 256; h++) {
            int inventory = B;
            int time = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = h - arr[i][j];

                    if (diff > 0) {
                        // 블록을 쌓아야 함 (1초)
                        inventory -= diff;
                        time += diff;
                    } else if (diff < 0) {
                        // 블록을 제거해야 함 (2초)
                        inventory -= diff; // 음수를 빼면 더하는 효과
                        time += Math.abs(diff) * 2;
                    }
                }
            }

            if (inventory < 0) {
                // 인벤토리에 블록이 부족한 경우
                continue;
            }

            if (minT > time || (minT == time && maxH < h)) {
                minT = time;
                maxH = h;
            }
        }

        System.out.println(minT + " " + maxH);
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