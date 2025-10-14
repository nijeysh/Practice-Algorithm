import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static boolean[] visited;
    static long totalDepth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1, 0);

        // 총 깊이의 합이 홀수면 선공 승리
        if (totalDepth % 2 == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    static void dfs(int node, int depth) {
        visited[node] = true;
        boolean isLeaf = true;

        for (int child : tree[node]) {
            if (!visited[child]) {
                isLeaf = false;
                dfs(child, depth + 1);
            }
        }

        if (isLeaf) {
            totalDepth += depth;
        }
    }
}