public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();

        int[][] arr = new int[41][2];
        arr[0][0] = 1;
        arr[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
            arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = read();

            sb.append(arr[n][0]).append(" ").append(arr[n][1]).append("\n");
        }
        System.out.print(sb);
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