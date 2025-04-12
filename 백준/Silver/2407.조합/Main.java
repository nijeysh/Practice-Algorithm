import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        for (int i = 0; i < m; i++) {
            a = a.multiply(BigInteger.valueOf(n - i));
            b = b.multiply(BigInteger.valueOf(m - i));
        }

        System.out.println(a.divide(b));
    }
}
