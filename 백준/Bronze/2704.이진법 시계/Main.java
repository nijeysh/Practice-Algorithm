import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            String line = br.readLine().trim();   // 입력 형식: "HH:MM:SS"
            String[] parts = line.split(":");
            int H = Integer.parseInt(parts[0]);
            int M = Integer.parseInt(parts[1]);
            int S = Integer.parseInt(parts[2]);

            // 시, 분, 초를 각각 6자리 이진수로 만들기 (앞에 0채움)
            String binH = String.format("%6s", Integer.toBinaryString(H)).replace(' ', '0');
            String binM = String.format("%6s", Integer.toBinaryString(M)).replace(' ', '0');
            String binS = String.format("%6s", Integer.toBinaryString(S)).replace(' ', '0');

            // 3열 방식: 각 비트 행별로 H, M, S 순으로 읽기
            StringBuilder colStyle = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                colStyle.append(binH.charAt(i));
                colStyle.append(binM.charAt(i));
                colStyle.append(binS.charAt(i));
            }

            // 3행 방식: H(6비트) + M(6비트) + S(6비트) 순으로 읽기
            StringBuilder rowStyle = new StringBuilder();
            rowStyle.append(binH);
            rowStyle.append(binM);
            rowStyle.append(binS);

            // 출력: 3열 방식 + 공백 + 3행 방식
            System.out.println(colStyle.toString() + " " + rowStyle.toString());
        }
    }
}
