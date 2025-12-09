public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
        }

        int max = 0;
        int maxIndex = 1;

        // 출발점마다 visited 새로 생성
        for (int i = 1; i <= n; i++) {

            boolean[] visited = new boolean[n+1];
            int current = i;
            int count = 0;

            while (!visited[current]) {
                visited[current] = true;
                current = arr[current];
                count++;
            }

            if (count > max) {
                max = count;
                maxIndex = i;
            }
        }

        System.out.println(maxIndex);
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
