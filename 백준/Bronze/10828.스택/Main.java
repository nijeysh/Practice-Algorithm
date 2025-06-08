import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            stack(br.readLine());
        }

        System.out.print(sb);
//        bw.flush();
    }

    static void stack(String str) throws IOException {
        StringTokenizer st = new StringTokenizer(str);
        String command = st.nextToken();

        switch (command) {
            case "push": {
                stack.push(Integer.parseInt(st.nextToken()));
                break;
            }

            case "pop": {
//                bw.write(stack.isEmpty() ? -1 : stack.pop());
//                bw.newLine();
                sb.append(stack.isEmpty() ? -1 : stack.pop());
                sb.append("\n");
                break;
            }

            case "size": {
//                bw.write(stack.size());
//                bw.newLine();
                sb.append(stack.size());
                sb.append("\n");
                break;
            }

            case "empty": {
//                bw.write(stack.isEmpty() ? 1 : 0);
//                bw.newLine();
                sb.append(stack.isEmpty() ? 1 : 0);
                sb.append("\n");
                break;
            }

            case "top": {
//                bw.write(stack.isEmpty() ? -1 : stack.peek());
//                bw.newLine();
                sb.append(stack.isEmpty() ? -1 : stack.peek());
                sb.append("\n");
                break;
            }
        }
    }
}