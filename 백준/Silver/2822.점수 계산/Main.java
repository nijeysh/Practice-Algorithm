import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 1; i <= 8; i++) {
            int num = read();
            map.put(num, i);
        }

        int sum = 0;
        int idx = 0;
        int index = 0;
        int[] arr = new int[5];
        for (Integer score : map.keySet()) {
            if (idx++ < 3) continue;

            sum += score;
            int val = map.get(score);
            arr[index++] = val;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sum).append("\n");

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
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

