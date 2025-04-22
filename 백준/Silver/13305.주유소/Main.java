public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();     // 도시
        long[] line = new long[N - 1];

        int min = Integer.MAX_VALUE;
        long total = 0;
        for (int i = 0; i < line.length; i++) {
            line[i] = read();
        }

        for (int i = 0; i < N - 1; i++) {
            int cost = read();

            // 현재도시의 가격 비교
            min = Math.min(cost, min);
            total += line[i] * min;
        }

        System.out.println(total);
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