import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        long X = readLong();
        long Y = readLong();

        long Z = (Y * 100) / X;  // 소수점 버림
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long left = 1;
        long right = 1_000_000_000L;
        long answer = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long addZ = ((Y + mid) * 100) / (X + mid);  // 소수점 버림 (double로 처리하면 버그)

            if (addZ > Z) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static long readLong() throws IOException {
        int c;
        long n = 0;
        int sign = 1;
        while ((c = System.in.read()) <= 32) {
            if (c == -1) return -1;
        }
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        for (; c > 32; c = System.in.read()) {
            n = n * 10 + (c - '0');
        }
        return n * sign;
    }
}