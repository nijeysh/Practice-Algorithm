import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read(); // 횡단보도 개수
        int K = read(); // 연속한 K개의 신호등이 존재해야 함
        int B = read(); // 고장난 신호등 개수

        int[] lights = new int[N + 1];
        for (int i = 0; i < B; i++) {
            int broken = read();
            lights[broken] = 1; // 고장
        }

        // 초기 윈도우 (1 ~ K)
        int brokenCount = 0;
        for (int i = 1; i <= K; i++) {
            brokenCount += lights[i];
        }

        int min = brokenCount;

        // 슬라이딩 윈도우 (2 ~ N-K+1)
        for (int left = 2; left + K - 1 <= N; left++) {
            int right = left + K - 1;
            brokenCount = brokenCount - lights[left - 1] + lights[right];
            min = Math.min(min, brokenCount);
        }

        System.out.println(min);
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