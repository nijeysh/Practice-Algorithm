import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                for (int dx = -N; dx < N; dx++) {
                    for (int dy = -M; dy < M; dy++) {
                        if (dx == 0 && dy == 0) continue;
                        search(x, y, dx, dy);
                    }
                }
            }
        }

        System.out.println(max);
    }

    private static void search(int x, int y, int dx, int dy) {
        int num = 0;
        int nx = x, ny = y;

        while (nx >= 0 && nx < N && ny >= 0 && ny < M) {
            num = num * 10 + map[nx][ny];
            if (isPerfectSquare(num)) {
                max = Math.max(max, num);
            }
            nx += dx;
            ny += dy;
        }
    }

    private static boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
