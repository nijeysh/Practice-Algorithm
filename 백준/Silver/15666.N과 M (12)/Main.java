import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        HashSet<Integer> set = new HashSet<>();
        // 같거나 커야한다.
        for (int i = 0; i < N; i++) {
            set.add(read());    // 중복제거
        }

        arr = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            arr[index++] = num;
        }

        Arrays.sort(arr);   // 오름차순
        selected = new int[M];

        find(0, 0);
        System.out.print(sb);
    }

    static void find(int start, int depth) {
        if (depth >= M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]);
                if (i < M - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i < arr.length; i++) {
            selected[depth] = arr[i];
            find(i, depth + 1);
        }
    }

    private static int read() throws Exception {
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
        return sign * n;
    }
}
