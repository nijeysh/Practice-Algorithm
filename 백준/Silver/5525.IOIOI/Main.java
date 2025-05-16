import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());    // S의 길이

        String S = br.readLine();
        char ch = 'I';
        char c = 'I';
        int seq = 0;
        int total = 0;
        for (int i = 0; i < M; i++) {
            c = S.charAt(i);
            if (ch == c) {
                // 정상적인 순서일 때
                if (ch == 'I') {
                    ch = 'O';
                } else if (ch == 'O') {
                    ch = 'I';
                    seq++;  // 'O' 일때 +1
                }
            } else {
                // I순서인데 O가 들어왔을 때
                if (ch == 'I' && c == 'O') {
                    seq--;
                }

                if (seq > (N - 1)) {
                    total += seq - (N - 1);
                }

                seq = 0;
                if (c == 'I') {
                    ch = 'O';
                } else {
                    ch = 'I';
                }
            }
        }

        // 연속일때
        if (c == 'O' && seq > (N - 1)) {
            seq--;
            total += seq - (N - 1);
        } else if (c == 'I' && seq > (N - 1)) {
            total += seq - (N - 1);
        }

        System.out.println(total);
    }
}