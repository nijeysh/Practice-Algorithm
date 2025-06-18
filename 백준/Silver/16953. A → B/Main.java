import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 2를 곱한다
        // 1을 수의 가장 오른쪽에 추가한다.
        // 1,000,000,000

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int result = 0;
        if (A > B) {
            result = -1;
        } else if (A == B) {
            result = 0;
        } else {
            result = bfs(A, B);
        }

        System.out.println(result);
    }

    static int bfs(int A, int B) {
        // 각 숫자에 가장 빠르게 도달하는 횟수...
        // 그러면 distance도 있어야하고..
        // 숫자, distance
        HashMap<Integer, Integer> visited = new HashMap();
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(A);
        visited.put(A, 1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int distance = visited.get(current);
            if (current == B) {
                return distance;
            }

            // 이건 불가능한 케이스이므로 끝
            if (current > 1_000_000_000) {
                continue;
            }

            // 2를 곱하기
            int caseA = current * 2;
            // 이미 방문한 곳은 들르지 않는다.
            if (visited.get(caseA) == null) {
                queue.offer(caseA);
                visited.put(caseA, distance + 1);
            }

            // 1을 가장 오른쪽에 추가하기
            if (current <= 100_000_000) {
                int caseB = (current * 10) + 1;
                if (visited.get(caseB) == null) {
                    queue.offer(caseB);
                    visited.put(caseB, distance + 1);
                }
            }
        }

        return -1;
    }
}