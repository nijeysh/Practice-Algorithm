import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // 산성 -> 1 ~ 1,000,000,000
        // 알칼리성 -> -1 ~ -1,000,000,000
        // 두개의 서로 다른 용액을 혼합하여 0에 가까운 용액을 만들어내는 프로그램
        int INF = Integer.MAX_VALUE;
        int N = read();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);

        int left = 0;
        int right = N-1;

        int finalLeft = 0;
        int finalRight = N-1;
        int finalNumber = INF;

        while (left < right) {
            int sum = Math.abs(arr[left] + arr[right]);
            if (finalNumber > sum) {
                finalNumber = sum;
                finalLeft = left;
                finalRight = right;
            }

            if (sum == 0) {
                finalLeft = left;
                finalRight = right;
                break;
            }

            // 현재왼쪽 + 다음 오른쪽
            // 다음왼쪽 + 현재오른쪽
            if (Math.abs(arr[left] + arr[right-1]) > Math.abs(arr[left+1] + arr[right])) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(arr[finalLeft] + " " + arr[finalRight]);
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

