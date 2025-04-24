import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static void process(String cal, String x) {
        switch (cal) {
            case "add": {
                set.add(x);
                break;
            }
            case "remove": {
                set.remove(x);
                break;
            }
            case "check": {
                if (set.contains(x)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
                break;
            }
            case "toggle": {
                if (set.contains(x)) {
                    set.remove(x);
                } else {
                    set.add(x);
                }
                break;
            }

            case "all": {
                for (int i = 1; i <= 20; i++) {
                    set.add(i + "");
                }
                System.out.println("all: " + set);
                break;
            }

            case "empty": {
                set.clear();
            }
        }
    }
}

