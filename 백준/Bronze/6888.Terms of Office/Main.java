import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine().trim()); // 시작 연도
        int Y = Integer.parseInt(br.readLine().trim()); // 끝 연도

        for (int year = X; year <= Y; year++) {
            if ((year - X) % 60 == 0) {
                System.out.println("All positions change in year " + year);
            }
        }
    }
}
