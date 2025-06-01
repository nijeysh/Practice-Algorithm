import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }

        int left = 0;
        int kind = 0;   // 서로 다른 과일의 개수
        int maxLen = 0; // 최대 길이
        int[] fruits = new int[10];

        for (int right = 0; right < N; right++) {
            int current = arr[right];
            fruits[current]++;

            if (fruits[current] == 1) {
                kind++;

                while (kind > 2) {
                    int leftFruit = arr[left];
                    fruits[leftFruit]--;

                    if (fruits[leftFruit] == 0) {
                        kind--;
                    }
                    left++;
                }
            }

            int currentLen = right - left + 1;  // 배열의 길이
            maxLen = Math.max(maxLen, currentLen);
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