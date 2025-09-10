public class Main {
    public static void main(String[] args) throws Exception {
        int X = read();
        int Y = read();
        int Z = (int) ((double) Y / X * 100);

        // Z가 이미 99 이상이면 절대 변하지 않음
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        int left = 1;
        int right = 1_000_000_000;
        int answer = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 오버플로우 방지

            // mid번 더 게임해서 모두 이겼을 때의 승률
            int addZ = (int) ((double) (Y + mid) / (X + mid) * 100);

            if (addZ > Z) {
                // 승률이 증가했다면, 더 적은 게임으로도 가능한지 확인 (mid보다 작은 값으로 할 수 있는지)
                answer = mid;
                right = mid - 1;
            } else {
                // 승률이 증가하지 않았다면, 더 많은 게임이 필요 (mid보다 큰 값)
                left = mid + 1;
            }
        }

        System.out.println(answer);
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