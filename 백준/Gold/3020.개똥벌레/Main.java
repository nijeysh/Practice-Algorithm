import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // 석순 -> 종류석 -> 석순 -> ...
        int N = read(); // 길이(짝수), 2 <= N <= 200,000
        int H = read(); // 높이, 2 <= H <= 500,000

        int len = N/2;
        int[] left = new int[H+1];
        int[] right = new int[H+1];
        for (int i = 0; i < len; i++) {
            int l = read();
            int r = read();
            left[H-l+1] += 1;
            right[r] += 1;
        }

        for (int i = 1; i <= H; i++) {
            left[i] += left[i-1];
        }
        for (int i = H-1; i > 0; i--) {
            right[i] += right[i+1];
        }

        int[] sum = new int[H+1];
        for (int i = 1; i <= H; i++) {
            sum[i] = left[i] + right[i];
        }

        Arrays.sort(sum);

        int min = 400_001;
        int count = 0;
        for (int i = 1; i <= H; i++) {
            if (min < sum[i]) {
                break;
            } else {
                min = sum[i];
                count++;
            }
        }

        System.out.print(min + " " + count);
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