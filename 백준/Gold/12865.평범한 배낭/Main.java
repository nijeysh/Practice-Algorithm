import java.util.Arrays;
public class Main {
    /**
     * 준서가 여행에 필요하다고 생각하는 N개의 물건이 있다.
     * 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다.
     * 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다.
     * 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
     */
    public static void main(String[] args) throws Exception {
        // 물품의 수
        int N = read();

        // 최대 무게
        int K = read();
        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int W = read(); // 물건의 무게
            int V = read(); // 물건의 가치

            // 뒤에서부터 갱신 (0-1 배낭)
            for (int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j], dp[j - W] + V);
            }
        }

        System.out.println(dp[K]);
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