import java.util.*;

public class Main {

    static int N, K;
    static int[][] color;
    static Horse[] horses;
    static Deque<Integer>[][] board;

    // 0: 오른쪽, 1: 왼쪽, 2: 위, 3: 아래
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    static class Horse {
        int r, c, d;
        Horse(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {

        N = read();
        K = read();

        color = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                color[i][j] = read();
            }
        }

        board = new ArrayDeque[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new ArrayDeque<>();
            }
        }

        horses = new Horse[K];
        for (int i = 0; i < K; i++) {
            int r = read() - 1;
            int c = read() - 1;
            int d = read() - 1;
            horses[i] = new Horse(r, c, d);
            board[r][c].addLast(i);
        }

        int turn = 0;
        while (turn <= 1000) {
            turn++;

            for (int i = 0; i < K; i++) {
                Horse h = horses[i];

                int nr = h.r + dr[h.d];
                int nc = h.c + dc[h.d];

                // 파란색 or 범위 밖
                if (!inRange(nr, nc) || color[nr][nc] == 2) {
                    h.d = reverse(h.d);
                    nr = h.r + dr[h.d];
                    nc = h.c + dc[h.d];

                    if (!inRange(nr, nc) || color[nr][nc] == 2) {
                        continue;
                    }
                }

                // 현재 칸에서 이동할 말들 분리
                Deque<Integer> cur = board[h.r][h.c];
                Deque<Integer> moving = new ArrayDeque<>();

                while (true) {
                    int x = cur.pollLast();
                    moving.addFirst(x);
                    if (x == i) break;
                }

                // 빨간색이면 순서 뒤집기
                if (color[nr][nc] == 1) {
                    Deque<Integer> reversed = new ArrayDeque<>();
                    while (!moving.isEmpty()) {
                        reversed.addLast(moving.pollLast());
                    }
                    moving = reversed;
                }

                // 다음 칸에 붙이기
                for (int idx : moving) {
                    board[nr][nc].addLast(idx);
                    horses[idx].r = nr;
                    horses[idx].c = nc;
                }

                // 종료 조건
                if (board[nr][nc].size() >= 4) {
                    System.out.println(turn);
                    return;
                }
            }
        }

        System.out.println(-1);
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static int reverse(int d) {
        if (d == 0) return 1;
        if (d == 1) return 0;
        if (d == 2) return 3;
        return 2;
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