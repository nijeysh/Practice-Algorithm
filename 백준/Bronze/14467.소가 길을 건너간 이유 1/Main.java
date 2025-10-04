import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();

        int[] cowLocation = new int[11];
        Arrays.fill(cowLocation, -1);

        int crossCount = 0;

        for (int i = 0; i < N; i++) {
            int cowNum = read();
            int location = read();

            if (cowLocation[cowNum] != -1 && cowLocation[cowNum] != location) {
                crossCount++;
            }

            cowLocation[cowNum] = location;
        }

        System.out.println(crossCount);
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