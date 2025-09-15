import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        // 10의 배수 조건: 0 포함 여부
        if (!N.contains("0")) {
            System.out.println(-1);
            return;
        }

        // 3의 배수 조건: 자릿수 합
        int sum = 0;
        char[] arr = N.toCharArray();
        for (char c : arr) {
            sum += c - '0';
        }

        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        // 가장 큰 수 만들기 → 내림차순 정렬
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder(new String(arr));
        System.out.println(sb.reverse());
    }
}
