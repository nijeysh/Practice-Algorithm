import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        // 하루에 묘목 1개만 심을 수 있다.
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int t = read();
            arr[i] = t;
        }

        Arrays.sort(arr);
        int max = arr[N-1];
        for (int i = 0; i < N; i++) {
            max = Math.max(arr[N-i-1] + i, max);
        }

        System.out.println(max+2);
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