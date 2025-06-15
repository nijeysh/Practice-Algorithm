import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int userNumber = 1;
        String line;

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }

            int L = Integer.parseInt(line.trim());

            if (L == 0) {
                break;
            }

            bw.write("User " + userNumber);
            bw.newLine();

            int N = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < N; i++) {
                int steps = Integer.parseInt(br.readLine().trim());
                double distanceKm = (double) steps * L / 100000.0;
                bw.write(String.format(Locale.US, "%.5f", distanceKm));
                bw.newLine();
            }
            userNumber++;
        }

        bw.flush();
        br.close();
        bw.close();
    }
}