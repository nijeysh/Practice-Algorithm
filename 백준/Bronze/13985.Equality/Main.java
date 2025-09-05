import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int a = line.charAt(0) - '0';  // 첫 번째 숫자
        int b = line.charAt(4) - '0';  // 세 번째 숫자 (+ 다음)
        int c = line.charAt(8) - '0';  // 다섯 번째 숫자 (= 다음)

        // a + b가 c와 같은지 확인
        if (a + b == c) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}