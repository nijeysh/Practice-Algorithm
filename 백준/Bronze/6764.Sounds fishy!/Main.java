import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] depth = new int[4];
        for (int i = 0; i < 4; i++) {
            depth[i] = Integer.parseInt(br.readLine());
        }

        boolean isIncreasing = depth[0] < depth[1] && depth[1] < depth[2] && depth[2] < depth[3];
        boolean isDecreasing = depth[0] > depth[1] && depth[1] > depth[2] && depth[2] > depth[3];
        boolean isSame = depth[0] == depth[1] && depth[1] == depth[2] && depth[2] == depth[3];

        if (isIncreasing) {
            System.out.println("Fish Rising");
        } else if (isDecreasing) {
            System.out.println("Fish Diving");
        } else if (isSame) {
            System.out.println("Fish At Constant Depth");
        } else {
            System.out.println("No Fish");
        }
    }
}
