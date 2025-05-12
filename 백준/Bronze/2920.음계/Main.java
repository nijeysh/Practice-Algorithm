import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] notes = new int[8];

        for (int i = 0; i < 8; i++) {
            notes[i] = Integer.parseInt(st.nextToken());
        }

        if (isAscending(notes)) {
            System.out.println("ascending");
        } else if (isDescending(notes)) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }

    private static boolean isAscending(int[] arr) {
        for (int i = 0; i < 7; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDescending(int[] arr) {
        for (int i = 0; i < 7; i++) {
            if (arr[i] - 1 != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
