import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 1,000

        if (N < 100) {                 // 1~99는 모두 한수
            System.out.println(N);
            return;
        }

        int count = 99;                // 100 이상일 때 1~99는 미리 카운트
        int upper = Math.min(N, 999);  // 1000은 한수가 아님

        for (int x = 100; x <= upper; x++) {
            int a = x / 100;           // 백의 자리
            int b = (x / 10) % 10;     // 십의 자리
            int c = x % 10;            // 일의 자리
            if ((a - b) == (b - c)) count++;
        }

        System.out.println(count);
    }
}