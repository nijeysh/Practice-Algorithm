public class Main {
    /**
     * 이 아파트에 거주를 하려면 조건이 있는데,
     * “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
     *
     * 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때,
     * 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
     * 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
     */
    public static void main(String[] args) throws Exception {
        int T = read();

        // 1 ≤ k, n ≤ 14
        int[][] arr = new int[15][15];
        for (int i = 1; i < 15; i++) {
            arr[0][i] = i;
        }

        // a층의 b호에 살려면 자신의 a-1층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
        // 1층의 1호 -> 0층의 1호부터 1호까지 => 1
        // 1층의 2호 -> 0층의 1호부터 2호까지 => 2
        for (int a = 1; a < 15; a++) {
            for (int b = 1; b < 15; b++) {
                arr[a][b] = arr[a][b - 1] + arr[a - 1][b];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = read();
            int n = read();

            sb.append(arr[k][n]).append("\n");
        }

        System.out.print(sb);
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
