import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        StringBuilder sbInput = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue; // 빈 라인은 무시
            sbInput.append(line).append(' ');
        }
        st = new StringTokenizer(sbInput.toString());

        int n = Integer.parseInt(st.nextToken());
        long minVal = Long.MAX_VALUE;
        int minIdx = 0;

        for (int i = 0; i < n; i++) {
            if (!st.hasMoreTokens()) break; // 안전장치
            long v = Long.parseLong(st.nextToken());
            if (v < minVal) {
                minVal = v;
                minIdx = i;
            }
        }

        System.out.println(minIdx);
    }
}
