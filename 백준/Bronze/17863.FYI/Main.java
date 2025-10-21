import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine().trim(); // 전화번호 입력
        br.close();

        if (number.length() == 7 && number.startsWith("555")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
