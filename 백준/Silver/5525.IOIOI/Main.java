import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 패턴의 길이 (N+1)
        int M = Integer.parseInt(br.readLine());  // 문자열 S의 길이
        String S = br.readLine();

        int result = 0;
        int patternCount = 0;

        // IOI 패턴 찾기
        for (int i = 0; i < M - 2; i++) {
            // 현재 위치에서 "IOI" 패턴이 시작되는지 확인
            if (S.charAt(i) == 'I' && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                patternCount++;

                // N개의 패턴이 연속으로 나타났는지 확인 (즉, P_N을 발견했는지)
                if (patternCount >= N) {
                    result++;
                }

                // 다음 'I'로 건너뛰기 (IOIOI...)
                i++;
            } else {
                // 패턴이 깨졌으므로 카운터 초기화
                patternCount = 0;
            }
        }

        System.out.println(result);
        br.close();
    }
}