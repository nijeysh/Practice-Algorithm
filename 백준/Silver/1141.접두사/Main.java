import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 단어의 개수

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            arr[i] = word;
        }

        Arrays.sort(arr);
        int[] count = new int[N];

        // System.out.println(Arrays.toString(arr));

        // refactoring
        // 시작 => answer = N
        // if (current.startsWith(prev)) { answer-- }
        // 더 짧은 접두사를 가진 단어를 제거한다.
        for (int i = 0; i < N; i++) {
            String str = arr[i];
            for (int j = i; j < N; j++) {
                if (!arr[j].startsWith(str)) {
                    count[j] = count[i]+1;
                }
            }
        }

        Arrays.sort(count);

        System.out.println(count[N-1]+1);
    }
}