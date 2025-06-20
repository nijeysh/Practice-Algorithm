import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 큰 수 입력
        BigInteger A = new BigInteger(br.readLine());
        // 두 번째 큰 수 입력
        BigInteger B = new BigInteger(br.readLine());

        // A + B 출력
        bw.write(A.add(B).toString() + "\n");
        // A - B 출력
        bw.write(A.subtract(B).toString() + "\n");
        // A × B 출력
        bw.write(A.multiply(B).toString() + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}