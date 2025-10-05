import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int N = read(); // 횡단보도 개수
        int K = read(); // 연속한 K개의 신호등이 존재해야함
        int B = read(); // 고장난 신호등 개수

        int[] lights = new int[N+1];
        for (int i = 0; i < B; i++) {
            int brokenLightNum = read();
            lights[brokenLightNum] = 1;
        }
        // 최소 몇 개의 신호등을 수리해야 하는가
        int currentBrokenLights = 0;
        int min = 0;    // 최소 개수 수리
        int left = 1;
        int right = 0;

        // 첫번째 슬라이딩
        while (true) {
            // K개만큼 가져야됨
            if (right < K) {
                right++;
                // 수리해야할 개수
                min += lights[right];
                currentBrokenLights += lights[right];
            } else if (right+1 > N) {
                break;
            } else {
                // System.out.println("currentBrokenLights: " + currentBrokenLights);
                // System.out.println("right: " + right);
                // 다음 슬라이딩 계산
                int prevLeft = lights[left];

                left++;
                right++;

                int nextRight = lights[right];

                currentBrokenLights = currentBrokenLights - prevLeft + nextRight;
                min = Math.min(min, currentBrokenLights);
            }
        }

        System.out.println(min);
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