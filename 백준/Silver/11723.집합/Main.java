import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static HashSet<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(" ");
            if (arr.length == 2) {
                process(arr[0], arr[1]);
            } else {
                process(arr[0], "");
            }
        }

        System.out.println(sb);
    }

    static void process(String cal, String target) {
        if (target.isEmpty()) return;

        switch (cal) {
            case "add": {
                set.add(target);
                break;
            }
            case "remove": {
                set.remove(target);
                break;
            }
            case "check": {
                if (set.contains(target)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
                break;
            }
            case "toggle": {
                if (set.contains(target)) {
                    set.remove(target);
                } else {
                    set.add(target);
                }
                break;
            }

            case "all": {
                for (int i = 1; i <= 20; i++) {
                    set.add(i + "");
                }
                break;
            }

            case "empty": {
                set.clear();
            }
        }
    }
}

