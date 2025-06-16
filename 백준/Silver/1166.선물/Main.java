import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        double L = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());

        double left = 0.0;
        double right = Math.min(L, Math.min(W, H));

        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;

            long countL = (long) (L / mid);
            long countW = (long) (W / mid);
            long countH = (long) (H / mid);

            if ((double) countL * countW * countH >= N) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }
}