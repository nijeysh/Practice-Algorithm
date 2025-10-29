import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        while (true) {
            int N = read();

            if (N == 0) {
                break;
            }

            int leftNum = N / 2;
            int rightNum = N / 2;
            if (N % 2 != 0) {
                leftNum += 1;
            }

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = read();
            }

            Arrays.sort(arr);
            // 맨 처음은 0이 될 수 없다.
            if (arr[0] == 0) {
                for (int i = 1; i < N; i++) {
                    if (arr[i] != 0) {
                        arr[0] = arr[i];
                        arr[i] = 0;
                        break;
                    }
                }
            }
            if (arr[1] == 0) {
                for (int i = 2; i < N; i++) {
                    if (arr[i] != 0) {
                        arr[1] = arr[i];
                        arr[i] = 0;
                        break;
                    }
                }
            }

            // System.out.println(Arrays.toString(arr));

            int left = 0;
            int right = 0;
            int leftIndex = 0;
            if (N % 2 == 0) {
                // 짝수
                for (int i = 0; i < N; i+=2) {
                    left *= 10;
                    right *= 10;
                    left += arr[i];
                    right += arr[i+1];
                }

            } else {
                // 홀수
                left += arr[0];
                for (int i = 1; i < N; i+=2) {
                    left *= 10;
                    right *= 10;
                    left += arr[i];
                    right += arr[i+1];
                }
            }

            System.out.println(left+right);
        }
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