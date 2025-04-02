public class Main {
    /**
     * n개의 정수로 이루어진 임의의 수열이 주어진다.
     * 우리는 이 중 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하려고 한다.
     * 단, 수는 한 개 이상 선택해야 한다.
     *
     * 예를 들어서 10, -4, 3, 1, 5, 6, -35, 12, 21, -1 이라는 수열이 주어졌다고 하자.
     * 여기서 정답은 12+21인 33이 정답이 된다.
     */
    static int[] arr;
    public static void main(String[] args) throws Exception {
        int n = read();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }

        int max = arr[0];
        int currentMax = arr[0];
        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]); // 현재 위치에서 최대값
            max = Math.max(max, currentMax);
        }

        System.out.println(max);
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
