import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // M X N 
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);   // 세로
        int M = Integer.parseInt(str[1]);   // 가로
        int K = Integer.parseInt(str[2]);   // KxK 보드

        // 0 -> 시작점이 B, 1 -> 시작점이 W
        int[][][] sum = new int[N + 1][M + 1][2];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            // 다시 칠해야하는 값을 저장하기
            for (int j = 1; j <= M; j++) {
                boolean even = (i + j) % 2 == 0;
                boolean isBlack = line.charAt(j - 1) == 'B';

                // 시작이 B일 때 틀렸으면 +1
                int wrongIfStartB = (even && isBlack) || (!even && !isBlack) ? 0 : 1;

                // 시작이 W일 때 틀렸으면 +1
                int wrongIfStartW = (even && !isBlack) || (!even && isBlack) ? 0 : 1;

                sum[i][j][0] = sum[i - 1][j][0] + sum[i][j - 1][0] - sum[i - 1][j - 1][0] + wrongIfStartB;
                sum[i][j][1] = sum[i - 1][j][1] + sum[i][j - 1][1] - sum[i - 1][j - 1][1] + wrongIfStartW;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                int wrongB = sum[i][j][0] - sum[i-K][j][0] - sum[i][j-K][0] + sum[i-K][j-K][0];
                int wrongW = sum[i][j][1] - sum[i-K][j][1] - sum[i][j-K][1] + sum[i-K][j-K][1];

                min = Math.min(min, Math.min(wrongB,wrongW));
            }
        }

        System.out.println(min);
    }
}
