public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        boolean[][] pass = new boolean[N + 1][N + 1];

        // 아이스크림 3개
        // 3개의 조합은 섞어먹으면 안됨
        for (int i = 0; i < M; i++) {
            int a = read();
            int b = read();

            pass[a][b] = true;
            pass[b][a] = true;
        }

        int count = 0;
        // 1 - 2, 2 - 3, 1 - 3
        // 첫번째
        for (int i = 0; i < N-2; i++) {
            // 두번째
            for (int j = i+1; j < N-1 ;j++) {
                if (pass[i][j] || pass[j][i]) {
                    continue;
                }

                // 세번째
                for (int k = j+1; k < N; k++) {
                    if (pass[i][k] || pass[j][k] || pass[k][i] || pass[k][j]) {
                        continue;
                    }
                    count++;
                }
            }
        }

        System.out.println(count);
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

