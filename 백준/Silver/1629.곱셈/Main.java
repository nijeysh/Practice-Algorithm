import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int B;
    static int C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(modPow(A, B, C));
    }

    static long modPow(long base, long exponent, long mod) {
        long result = 1;    // 결과 초기화
        base %= mod;        // overflow 방지

        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % mod; // 지수가 홀 수 일 때 result에 base(A)를 곱함
            }
            base = (base * base) % mod;     // 제곱
            exponent >>= 1;                 // 2로 나누기 (exponent = exponent / 2)
        }

        return result;
    }
}
