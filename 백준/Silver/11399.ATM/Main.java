import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);
        int sum = arr[0];
        for (int i = 1; i < N; i++) {
            arr[i] += arr[i - 1];
            sum += arr[i];
        }

        System.out.println(sum);
    }

    static int read() throws Exception {
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
