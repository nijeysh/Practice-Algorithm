import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String str1 = br.readLine();
            String str2 = br.readLine();

            int hammingDistance = 0;

            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    hammingDistance++;
                }
            }

            sb.append("Hamming distance is ").append(hammingDistance).append(".\n");
        }

        System.out.print(sb);
    }
}