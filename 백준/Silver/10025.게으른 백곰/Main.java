import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 얼음 양동이 개수
        int K = Integer.parseInt(st.nextToken());   // K만큼 떨어진 곳까지 닿을 수 있다

        int[] buckets = new int[1_000_001]; // 좌표의 얼음의 양
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());    // 얼음의 양
            int x = Integer.parseInt(st.nextToken());    // 양동이의 좌표

            buckets[x] = g;
        }

        int slidingSize = 2*K + 1;  // 범위 +-K
        long currentSum = 0;
        long maxSum = 0;

        int len = buckets.length;
        for (int i = 0; i < len; i++) {
            currentSum += buckets[i];

            // 다음 슬라이딩으로 이동하여 해당하지 않는 범위의 양은 빼기
            if (i >= slidingSize) {
                currentSum -= buckets[i-slidingSize];
            }

            maxSum = Math.max(currentSum, maxSum);
        }

        System.out.println(maxSum);
    }
}
