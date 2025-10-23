import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 위치 매핑: num -> {r, c}
        int[][] pos = new int[26][2];
        for (int r = 0; r < 5; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                int num = Integer.parseInt(st.nextToken());
                pos[num][0] = r;
                pos[num][1] = c;
            }
        }

        // 호출 숫자 순서를 25개 읽어 처리
        int[] calls = new int[25];
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                calls[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] marked = new boolean[5][5];
        int[] rowCnt = new int[5];
        int[] colCnt = new int[5];
        int diag1 = 0, diag2 = 0;
        boolean[] rowDone = new boolean[5];
        boolean[] colDone = new boolean[5];
        boolean d1Done = false, d2Done = false;
        int lines = 0;

        for (int i = 0; i < 25; i++) {
            int call = calls[i];
            int r = pos[call][0];
            int c = pos[call][1];
            if (!marked[r][c]) {
                marked[r][c] = true;
                rowCnt[r]++;
                colCnt[c]++;
                if (r == c) diag1++;
                if (r + c == 4) diag2++;

                if (rowCnt[r] == 5 && !rowDone[r]) {
                    rowDone[r] = true;
                    lines++;
                }
                if (colCnt[c] == 5 && !colDone[c]) {
                    colDone[c] = true;
                    lines++;
                }
                if (diag1 == 5 && !d1Done) {
                    d1Done = true;
                    lines++;
                }
                if (diag2 == 5 && !d2Done) {
                    d2Done = true;
                    lines++;
                }
            }
            if (lines >= 3) {
                System.out.println(i + 1); // 몇 번째 호출인지(1-based)
                return;
            }
        }
    }
}
