import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (ch < 97) {
                    sb.append((char) (ch + 32));
                } else {
                    sb.append(ch);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}