import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class State {
        int num;
        String command;
        State(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

    static String[] cmdList = {"D", "S", "L", "R"};
    public static void main(String[] args) throws Exception {
        int T = read();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int a = read();
            int b = read();
            // a -> b

            sb.append(bfs(a, b, "")).append("\n");
        }

        System.out.print(sb);
    }

    static String bfs(int start, int end, String sequence) {
        Queue<State> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[10000]; // 0 ~ 9999

        queue.offer(new State(start, sequence));
        visited[start] = true;
        while (!queue.isEmpty()) {
            State current = queue.poll();
            if (current.num == end) {
                return current.command;
            }

            for (int i = 0; i < 4; i++) {
                String cmd = cmdList[i];
                int nextNum = DSLR(cmd, current.num);
                if (!visited[nextNum]) {
                    visited[nextNum] = true;
                    queue.offer(new State(nextNum, current.command + cmd));
                }
            }
        }
        return sequence;
    }

    static int DSLR(String command, int n) {
        int result;
        switch (command) {
            case "D":
                result = n * 2;
                result = result < 10000 ? result : result % 10000;
                return result;
            case "S":
                result = n == 0 ? 9999 : n - 1;
                return result;
            case "L":
                // 자릿수
                return (n % 1000) * 10 + (n / 1000);
            case "R":
                return (n % 10) * 1000 + (n / 10);
        }
        return n;
    }

    static int read() throws Exception {
        int c, n, sign = 1;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        n = c & 15;
        while((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n * sign;
    }
}
