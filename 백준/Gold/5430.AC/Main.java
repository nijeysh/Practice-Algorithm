import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            char[] p = br.readLine().toCharArray();

            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            Deque<String> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] arr = str.substring(1, str.length() - 1).split(",");
                for (int j = 0; j < arr.length; j++) {
                    deque.add(arr[j]);
                }
            }

            bw.write(process(deque, p));
            bw.newLine();
        }
        bw.flush();
    }

    static String process(Deque<String> deque, char[] p) {
        boolean reverse = false;
        boolean isError = false;

        for (int i = 0; i < p.length; i++) {
            if (p[i] == 'R') {
                reverse = !reverse;
            } else if (p[i] == 'D') {
                if (deque.isEmpty()) {
                    isError = true;
                    break;
                }

                if (reverse) {
                    deque.pollLast();
                } else {
                    deque.pollFirst();
                }
            }
        }

        if (isError) {
            return "error";
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        int size = deque.size();
        if (size > 0) {
            if (reverse) {
                for (int i = 0; i < size - 1; i++) {
                    result.append(deque.pollLast()).append(",");
                }
                result.append(deque.pollLast());
            } else {
                for (int i = 0; i < size - 1; i++) {
                    result.append(deque.pollFirst()).append(",");
                }
                result.append(deque.pollFirst());
            }
        }

        result.append("]");
        return result.toString();
    }
}
