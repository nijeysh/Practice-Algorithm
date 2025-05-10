import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

        for (int i = 0; i < n; i++) {
            String result = br.readLine();  // OX 결과 입력 받기
            int score = 0;  // 총 점수
            int consecutive = 0;  // 연속된 O의 개수

            for (int j = 0; j < result.length(); j++) {
                if (result.charAt(j) == 'O') {
                    consecutive++;  // 연속된 O 개수 증가
                    score += consecutive;  // 현재 연속 점수를 총 점수에 더함
                } else {  // 'X'인 경우
                    consecutive = 0;  // 연속 점수 초기화
                }
            }

            bw.write(score + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}