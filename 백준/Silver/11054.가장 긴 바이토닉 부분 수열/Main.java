public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = read();
        }

        // 각 위치에서 끝나는 증가 부분수열의 최대 길이
        int[] inc = new int[N];
        // 각 위치에서 시작하는 감소 부분수열의 최대 길이
        int[] dec = new int[N];

        // 왼쪽에서 오른쪽으로 증가 부분수열 길이 계산
        for (int i = 0; i < N; i++) {
            inc[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        // 오른쪽에서 왼쪽으로 감소 부분수열 길이 계산
        for (int i = N - 1; i >= 0; i--) {
            dec[i] = 1;
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        // 각 위치를 정점으로 하는 바이토닉 수열의 최대 길이
        int maxLength = 1;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, inc[i] + dec[i] - 1);
        }

        System.out.println(maxLength);
    }

    static int read() throws Exception {
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
        return n * sign;
    }
}