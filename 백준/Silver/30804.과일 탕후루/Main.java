import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        int left = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            while (map.size() > 2) {
                int leftFruit = arr[left];
                map.put(leftFruit, map.get(leftFruit) - 1);
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                left++; // 왼 -> 오
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }


        System.out.println(maxLen);
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