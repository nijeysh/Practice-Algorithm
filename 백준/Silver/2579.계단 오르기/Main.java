public class Main {
    /**
     * 계단 오르기 게임은 계단 아래 시작점부터 계단 꼭대기에 위치한 도착점까지 가는 게임이다.
     * 각각의 계단에는 일정한 점수가 쓰여 있는데 계단을 밟으면 그 계단에 쓰여 있는 점수를 얻게 된다.
     *
     * 예를 들어 시작점에서부터 첫 번째, 두 번째, 네 번째, 여섯 번째 계단을 밟아 도착점에 도달하면 총 점수는 10 + 20 + 25 + 20 = 75점이 된다.
     * 계단 오르는 데는 다음과 같은 규칙이 있다.
     *
     * 1. 계단은 한 번에 한 계단씩 또는 두 계단씩 오를 수 있다. 즉, 한 계단을 밟으면서 이어서 다음 계단이나, 다음 다음 계단으로 오를 수 있다.
     * 2. 연속된 세 개의 계단을 모두 밟아서는 안 된다. 단, 시작점은 계단에 포함되지 않는다.
     * 3. 마지막 도착 계단은 반드시 밟아야 한다.
     *
     * 따라서 첫 번째 계단을 밟고 이어 두 번째 계단이나, 세 번째 계단으로 오를 수 있다.
     * 하지만, 첫 번째 계단을 밟고 이어 네 번째 계단으로 올라가거나, 첫 번째, 두 번째, 세 번째 계단을 연속해서 모두 밟을 수는 없다.
     *
     * 각 계단에 쓰여 있는 점수가 주어질 때 이 게임에서 얻을 수 있는 총 점수의 최댓값을 구하는 프로그램을 작성하시오.
     */
    public static void main(String[] args) throws Exception {
        int N = read(); // 계단의 개수

        int[] cost = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cost[i] = read();
        }

        int[][] dp = new int[N + 1][2];

        // [N][0] -> 두 칸
        // [N][1] -> 한 칸
        // 첫 번째
        dp[1][0] = cost[1];

        // 두번 째
        if (N >= 2) {
            dp[2][0] = cost[2];
            dp[2][1] = cost[1] + cost[2];
        }

        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + cost[i];
            dp[i][1] = dp[i-1][0] + cost[i];
        }

        System.out.println(Math.max(dp[N][0], dp[N][1]));

/*
        // int[] dp = new int[N + 1];
        // 1번째 계단에서 가질 수 있는 값
        // dp[0] = cost[0];

        // 2번째 계단에서 가질 수 있는 값
        // 1) 2번째 계단을 바로 올라 왔을때
        dp[1] = cost[1];
        // 2) 1번째 계단을 걷고 올라왔을 때
        dp[1] = cost[0] + cost[1];

        // 3번째 계단에서 가질 수 있는 값
        // 1) 1번째 계단을 걷지않고 2번째 계단에서 걸어왔을때
        dp[2] = cost[1] + cost[2];
        // 2) 1번째 계단에서 두 칸씩 올랐을때
        dp[2] = cost[0] + cost[2];

        // 4번째 계단에서 가질 수 있는 값
        // 1) 1번째 계단 + 2번째 계단 + 4번째 계단
        dp[3] = cost[0] + cost[1] + cost[3];
        // 2) 1번째 계단 + 3번째 계단 + 4번째 계단
        dp[3] = cost[0] + cost[2] + cost[3];
        // 3) 2번째 계단 + 4번째 계단
        dp[3] = cost[1] + cost[3];

        // 5번째 계단에서 가질 수 있는 값
        // 1) 1번째 + 2번째 + 4번째 + 5번째
        dp[4] = cost[0] + cost[1] + cost[3] + cost[4];
        // 2) 1번째 + 3번째 + 5번째
        dp[4] = cost[0]+ cost[2] + cost[4];
        // 3) 2번째 + 3번째 + 5번째
        dp[4] = cost[1] + cost[2] + cost[4];
        // 4) 2번째 + 4번째 + 5번째
        dp[4] = cost[1] + cost[3] + cost[4];
*/

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
