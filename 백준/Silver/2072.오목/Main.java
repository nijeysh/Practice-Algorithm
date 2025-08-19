import java.util.Arrays;

public class Main {
    static int[][] arr = new int[20][20];
    public static void main(String[] args) throws Exception {
        // 19x19 바둑판
        // 돌을 놓을 좌표
        // 몇 수만에 게임이 끝나는지?

        int result = -1;
        // 흑 먼저 시작, 번갈아 가면서 둔다.
        int N = read();
        for (int i = 1; i <= N; i++) {
            int r = read();
            int c = read();

            arr[r][c] = i;

            if (i >= 9) {
                if (findFive(r, c, (i % 2 != 0))) {
                    result = i;
                    break;
                }
            }
        }

        System.out.println(result);
    }

    static boolean findFive(int r, int c, boolean odd) {
        // 탐색할 위치
        // 가로, 세로, 양대각선, 음대각선

        // 가로 - 위아래
        int case1 = 1;
        for (int i = 1; i < 20; i++) {
            if (r+i > 19 || arr[r+i][c] == 0) break;

            boolean black = arr[r+i][c] % 2 != 0;
            if (odd && black) {
                case1++;
            }
            else if (!odd && !black) {
                case1++;
            }
            else {
                break;
            }

        }
        for (int i = 1; i < 20; i++) {
            if (r-i < 0 || arr[r-i][c] == 0) break;

            boolean black = arr[r-i][c] % 2 != 0;
            if (odd && black) {
                case1++;
            }
            else if (!odd && !black) {
                case1++;
            }
            else {
                break;
            }

        }

        // 세로 - 양옆
        int case2 = 1;
        for (int i = 1; i < 20; i++) {
            if (c+i > 19 || arr[r][c+i] == 0) break;

            boolean black = arr[r][c+i] % 2 != 0;
            if (odd && black) {
                case2++;
            }
            else if (!odd && !black) {
                case2++;
            }
            else {
                break;
            }
        }
        for (int i = 1; i < 20; i++) {
            if (c-i < 0 || arr[r][c-i] == 0) break;

            boolean black = arr[r][c-i] % 2 != 0;
            if (odd && black) {
                case2++;
            }
            else if (!odd && !black) {
                case2++;
            }
            else {
                break;
            }
        }

        // 양대각선
        int case3 = 1;
        for (int i = 1; i < 20; i++) {
            if (r+i > 19 || c+i > 19 || arr[r+i][c+i] == 0) break;

            boolean black = arr[r+i][c+i] % 2 != 0;
            if (odd && black) {
                case3++;
            }
            else if (!odd && !black) {
                case3++;
            }
            else {
                break;
            }

        }
        for (int i = 1; i < 20; i++) {
            if (r-i < 0 || c-i < 0 || arr[r-i][c-i] == 0) break;

            boolean black = arr[r-i][c-i] % 2 != 0;
            if (odd && black) {
                case3++;
            }
            else if (!odd && !black) {
                case3++;
            }
            else {
                break;
            }

        }

        // 음대각선
        int case4 = 1;
        for (int i = 1; i < 20; i++) {
            if (r+i > 19 || c-i < 0 || arr[r+i][c-i] == 0) break;

            boolean black = arr[r+i][c-i] % 2 != 0;
            if (odd && black) {
                case4++;
            }
            else if (!odd && !black) {
                case4++;
            }
            else {
                break;
            }

        }
        for (int i = 1; i < 20; i++) {
            if (r-i < 0 || c+i > 19 || arr[r-i][c+i] == 0) break;

            boolean black = arr[r-i][c+i] % 2 != 0;
            if (odd && black) {
                case4++;
            }
            else if (!odd && !black) {
                case4++;
            }
            else {
                break;
            }
        }

        if (case1 == 5 || case2 == 5 || case3 == 5 || case4 == 5) {
            return true;
        } else {
            return false;
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