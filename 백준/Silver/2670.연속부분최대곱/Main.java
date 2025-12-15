import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 10,000 이하의 자연수

        double max = 0.0;
        double current = 1.0;

        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(br.readLine());

            current = Math.max(num, current * num);
            max = Math.max(max, current);
        }

        System.out.printf("%.3f%n", max);
    }
}