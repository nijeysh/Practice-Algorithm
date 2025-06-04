import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch < 97) {
                ch = (char) (ch - 65 + 97);
            } else {
                ch = (char) (ch - 97 + 65);
            }

            sb.append(ch);
        }

        System.out.println(sb);
    }
}