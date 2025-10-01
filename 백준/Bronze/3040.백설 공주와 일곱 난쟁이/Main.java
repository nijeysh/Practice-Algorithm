import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        // 합계에서 제외해야 할 두 난쟁이의 합
        int excludeSum = sum - 100;

        int x = -1, y = -1;
        // 두 명 찾기
        outer: for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (arr[i] + arr[j] == excludeSum) {
                    x = i;
                    y = j;
                    break outer;
                }
            }
        }

        // 결과 출력 (순서 상관없이 7명 출력)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            if (i == x || i == y) continue;
            sb.append(arr[i]).append('\n');
        }

        System.out.print(sb);
    }
}
