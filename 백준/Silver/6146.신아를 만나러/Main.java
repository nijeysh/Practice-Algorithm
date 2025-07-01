import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int X;
    static int Y;
    static boolean[][] pool = new boolean[1_001][1_001];
    static boolean[][] visited = new boolean[1_001][1_001];

    static class Point {
        int r, c, d;

        Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        // (0, 0)에서 출발

        // 도착 좌표
        X = read();
        Y = read();

        int N = read(); // 웅덩이 개수

        // 웅덩이를 밟지말자!
        // 1001 로 계산한다. -500까지 가능임
        // pool = new boolean[1_001][1_001];
        for (int i = 0; i < N; i++) {
            int a = read();
            int b = read();

            pool[a+500][b+500] = true;
        }

        System.out.println(find());
    }

    static int find() {
        Queue<Point> queue = new ArrayDeque();
        visited[500][500] = true;
        // 0,0 시작
        queue.offer(new Point(500, 500, 0));
        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.r == (X+500) && current.c == (Y+500)) {
                return current.d;
            }

            for (int i = 0; i < 4; i++) {
                int cr = current.r + dr[i];
                int cc = current.c + dc[i];
                int cd = current.d + 1;

                if (cr >= 0 && cr <= 1000 && cc >= 0 && cc <= 1000
                        && !visited[cr][cc] && !pool[cr][cc]) {
                    queue.offer(new Point(cr, cc, cd));
                    visited[cr][cc] = true;
                }
            }
        }
        return -1;
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

