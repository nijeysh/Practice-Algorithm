import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            StringBuilder sb = new StringBuilder();

            char prev = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i == 0 || c != prev) {
                    sb.append(c);
                }
                prev = c;
            }

            System.out.println(sb.toString());
        }
    }
}
