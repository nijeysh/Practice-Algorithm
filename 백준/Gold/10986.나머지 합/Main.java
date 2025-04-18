import java.io.IOException;

public class Main {
    // 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램
    public static void main(String[] args) throws IOException {
        int N = read(); // 배열의 크기
        int M = read(); // 나누는 수

        long[] arr = new long[M];
        arr[0] = 1;

        long prefixSum = 0;
        long count = 0;
        for (int i = 0; i < N; i++) {
            prefixSum = (prefixSum + read()) % M;

            if (prefixSum < 0) prefixSum += M;

            count += arr[(int)prefixSum];

            arr[(int)prefixSum]++;
        }

        System.out.println(count);
    }

    static int read() throws IOException {
        int c, n = 0, sign = 1;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = System.in.read()) > 32);
        return n * sign;
    }
}