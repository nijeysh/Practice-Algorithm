import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();
        String target = br.readLine();

        int result = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < target.length(); j++) {
                if (i+j >= text.length()) {
                    break;
                }

                if (text.charAt(i+j) == target.charAt(j)) {
                    if (j == target.length() - 1) {
                        result++;
                        i = i+j;
                    }
                } else {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}