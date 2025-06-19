import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // BigInteger를 사용해서 매우 큰 수 처리
        BigInteger n = new BigInteger(st.nextToken()); // 총 돈
        BigInteger m = new BigInteger(st.nextToken()); // 생명체 수

        // 각 생명체가 받을 수 있는 돈 (몫)
        BigInteger quotient = n.divide(m);

        // 남는 돈 (나머지)
        BigInteger remainder = n.remainder(m);

        System.out.println(quotient);
        System.out.println(remainder);

        br.close();
    }
}