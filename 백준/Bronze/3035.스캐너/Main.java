import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ZR = Integer.parseInt(st.nextToken());
        int ZC = Integer.parseInt(st.nextToken());

        String[] arr = new String[R];
        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < R; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < C; j++) {
                char ch = arr[i].charAt(j);
                for (int x = 0; x < ZC; x++) {
                    row.append(ch);
                }
            }
            // vertically repeat the expanded row ZR times
            for (int y = 0; y < ZR; y++) {
                sb.append(row.toString()).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}