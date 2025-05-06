import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    static int[] trees;
    public static void main(String[] args) throws Exception {
        int N = read(); // 나무의 수
        int M = read(); // 나무의 길이

        trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = read();
        }

        long low = 0;
        long high = 1_000_000_000;
        long result = 0;
        while (low <= high) {
            long mid = (low + high) / 2;
            long total = calculate(mid);

            if (total >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);
    }

    static long calculate(long height) {
        long total = 0;
        for (int tree : trees) {
            if (tree > height) {
                total += tree - height;
            }
        }
        return total;
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
