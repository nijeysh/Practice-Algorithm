public class Main {
    public static void main(String[] args) throws Exception {
        int N = read(); // 2 <= N <= 100,000
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();    // 정렬된 순서
        }

        int left = 0;
        int right = N-1;
        int appr = Integer.MAX_VALUE;
        int leftV = arr[0];
        int rightV = arr[N-1];

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) < Math.abs(appr)) {
                appr = sum;
                leftV = arr[left];
                rightV = arr[right];
            }

            if (sum > 0) {
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                break;
            }
        }

        System.out.println(leftV + " " + rightV);
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

