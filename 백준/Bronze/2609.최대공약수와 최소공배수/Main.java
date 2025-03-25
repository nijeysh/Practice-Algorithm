import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int a = Integer.parseInt(arr[0]);
        int b = Integer.parseInt(arr[1]);

        System.out.println(gcd(a, b));
        System.out.print(lcm(a, b));
    }

    // 최대공약수 (GCD) 구하는 함수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    // 최소공배수 (LCM) 구하는 함수
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
