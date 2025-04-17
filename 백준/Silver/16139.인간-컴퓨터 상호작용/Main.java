import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();   // 문자열, S <= 200000
        int q = Integer.parseInt(br.readLine());    // 질문의 수
        int[][] arr = new int[S.length() + 1][26];

        for (int i = 0; i < S.length(); i++) {
            int alphabet = S.charAt(i) - 'a';

            for (int j = 0; j < 26; j++) {
                arr[i + 1][j] = arr[i][j];
            }

            arr[i + 1][alphabet] = arr[i][alphabet] + 1;
        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int a = st.nextToken().charAt(0) - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int count = arr[r + 1][a] - arr[l][a];

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
