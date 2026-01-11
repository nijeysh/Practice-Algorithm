import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int base = a % 10;
            int exp = b % 4;
            if (exp == 0) exp = 4;

            int result = 1;
            for (int j = 0; j < exp; j++) {
                result *= base;
            }

            result %= 10;
            if (result == 0) result = 10;

            sb.append(result).append('\n');
        }

        System.out.print(sb.toString());
    }
}
