import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 홀수일 때, 짝수일 때
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long max = 0L;
        int start = 0;
        int end;
        if (N % 2 == 0) {
            end = N-1;
        } else {
            end = N-2;
            max = arr[N-1];
        }

        // System.out.println(Arrays.toString(arr));
        // System.out.println("start: " + start + ", end: " + end + ", max: " + max);
        while (start < end) {
            max = Math.max(max, arr[start]+arr[end]);

            start++;
            end--;
        }

        System.out.println(max);
    }
}