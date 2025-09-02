public class Main {
    public static void main(String[] args) throws Exception {
        // N명이 사고싶어한다.
        // 각각 사람에게 배달비용
        // 지불 최대 금액 + 배송비
        int N = read();

        int[] pays = new int[N];
        int[] fees = new int[N];
        for (int i = 0; i < N; i++) {
            int pay = read();
            int fee = read();

            pays[i] = pay;
            fees[i] = fee;
        }

        int maxProfit = 0;
        int minPrice = 0;
        for (int i = 0; i < N; i++) {
            // 책정금액 pays[i] 일 때
            int sum = 0;
            for (int j = 0; j < N; j++) {
                // 지불할 수 있는 금액이 (pays[j]) 더 클 때만
                // 배송비까지 이익이 안나오면 안 팔 수도 있음
                if (pays[j] >= pays[i] && pays[i]-fees[j] > 0) {
                    sum += (pays[i] - fees[j]);
                }
            }
            if (maxProfit < sum) {
                maxProfit = sum;
                minPrice = pays[i];
            } else if (maxProfit == sum) {
                minPrice = Math.min(pays[i], minPrice);
            }
        }

        System.out.println(minPrice);
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