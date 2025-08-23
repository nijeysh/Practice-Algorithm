import java.io.*;
import java.util.*;

public class Main {

    static int toCol(char c) { return c - 'A'; }  // A~F → 0~5
    static int toRow(char c) { return c - '1'; }  // 1~6 → 0~5

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] visited = new boolean[6][6];
        int[][] path = new int[36][2];

        for (int i = 0; i < 36; i++) {
            String s = br.readLine().trim(); // 예: "A1"
            int c = toCol(s.charAt(0));
            int r = toRow(s.charAt(1));

            // 이미 방문했으면 Invalid
            if (visited[r][c]) {
                System.out.println("Invalid");
                return;
            }

            visited[r][c] = true;
            path[i][0] = c;
            path[i][1] = r;
        }

        // 인접 이동 체크
        for (int i = 1; i < 36; i++) {
            if (!isKnightMove(path[i-1][0], path[i-1][1], path[i][0], path[i][1])) {
                System.out.println("Invalid");
                return;
            }
        }

        // 마지막 → 첫 칸도 나이트 이동 확인
        if (!isKnightMove(path[35][0], path[35][1], path[0][0], path[0][1])) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }

    static boolean isKnightMove(int c1, int r1, int c2, int r2) {
        // "ㄱ"자 모양 이동
        int dc = Math.abs(c1 - c2);
        int dr = Math.abs(r1 - r2);
        return (dc == 1 && dr == 2) || (dc == 2 && dr == 1);
    }
}
