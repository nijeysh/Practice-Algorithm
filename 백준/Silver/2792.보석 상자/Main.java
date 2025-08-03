public class Main {
    public static void main(String[] args) throws Exception {
        int N = read(); // 학생 수
        int M = read(); // 보석상자 수 (색상 수)
        int[] arr = new int[M];
        int max = 0;
        for (int i = 0; i < M; i++) {
            arr[i] = read();
            max = Math.max(max, arr[i]);  // 최대 보석 수 저장
        }

        int left = 1;
        int right = max;
        int answer = max;

        while (left <= right) {
            int mid = (left + right) / 2;   // 질투심
            long count = 0;

            for (int i = 0; i < M; i++) {
                count += (arr[i] + mid - 1) / mid;  // 올림
            }

            if (count <= N) {
                answer = mid;  // 더 작게 할 수 있는지 확인
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
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
