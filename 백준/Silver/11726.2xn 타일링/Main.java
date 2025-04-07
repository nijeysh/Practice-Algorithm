public class Main {
    /**
     * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
     */
    public static void main(String[] args) throws Exception {
        //  1 ≤ n ≤ 1,000
        int n = read();

        int[] arr = new int[1001];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i < 1001; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }

        System.out.println(arr[n]);
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
