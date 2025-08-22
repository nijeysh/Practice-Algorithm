import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 손 수
        char B = st.nextToken().charAt(0);        // 우승 무늬 (dominant suit)

        int total = 0;

        for (int i = 0; i < 4 * N; i++) {
            String card = br.readLine().trim(); // 카드 한 장
            char rank = card.charAt(0);
            char suit = card.charAt(1);
            boolean dom = (suit == B);

            switch (rank) {
                case 'A': total += 11; break;
                case 'K': total += 4; break;
                case 'Q': total += 3; break;
                case 'J': total += dom ? 20 : 2; break;
                case 'T': total += 10; break;
                case '9': total += dom ? 14 : 0; break;
                // '8', '7' 은 0점
            }
        }

        bw.write(String.valueOf(total));
        bw.flush();
    }
}
