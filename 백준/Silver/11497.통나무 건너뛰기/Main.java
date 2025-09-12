import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        // N개의 통나무, 인접한 높이 차의 최소
        // 난이도 = 높이 차의 최대값
        int T = read();
        for (int i = 0; i < T; i++) {
            int N = read();
            int[] arr = new int[N];
            for (int k = 0; k < N; k++) {
                arr[k] = read();
            }

            // 1. 정렬
            Arrays.sort(arr);

            // 2. 최대값 구하기 - 지그재그 배치
            int max = 0;
            for (int k = 2; k < N; k++) {
                max = Math.max(max, arr[k] - arr[k-2]);
            }

            sb.append(max).append("\n");
        }

        System.out.print(sb);
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

