import java.util.Arrays;

public class Main {
    static int N;
    static boolean[] visited;
    static boolean[] possible;
    static int[] X;
    static int[] S;
    public static void main(String[] args) throws Exception {
        // N개의 다른 숫자로 구성되어있는 X
        N = read();

        X = new int[N];
        S = new int[2*N];
        visited = new boolean[2*N];
        possible = new boolean[17];
        for (int i = 0; i < N; i++) {
            int number = read();
            X[i] = number;
            possible[number] = true;
        }

        Arrays.sort(X);         // 정렬이 안되어있을 수도 있음..
        Arrays.fill(S, -1);

        if (find(0, 0)) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < S.length; i++) {
                sb.append(S[i]);
                if (i != S.length - 1) {
                    sb.append(" ");
                }
            }
            System.out.print(sb);
        } else {
            System.out.print("-1");
        }
    }

    // number 놓을 index
    static boolean find(int index, int depth) {
        if (index == S.length) {
            if (depth == N) {
                return true;
            }  else {
                return false;
            }
        }

        if (visited[index]) {
            return find(index+1, depth);
        }

        for (int i = 0; i < N; i++) {
            int number = X[i];  // 대입할 number 찾기
            if (possible[number] && index+number+1 < S.length && !visited[index+number+1]) {
                S[index] = number;
                S[index+number+1] = number;

                visited[index] = true;
                visited[index+number+1] = true;
                possible[number] = false;

                if (find(index+1, depth+1)) {
                    return true;
                }

                S[index] = -1;
                S[index+number+1] = -1;
                visited[index] = false;
                visited[index+number+1] = false;
                possible[number] = true;
            }
        }

        return false;
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