import java.io.IOException;
import java.util.PriorityQueue;

public class Main {
    /**
     * 숨바꼭질 3
     *
     * 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
     * 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
     * 순간이동을 하는 경우에는 0초 후에 2*X의 위치로 이동하게 된다.
     * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
     *
     * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
     */

    static int N, K;

    static class Node implements Comparable<Node> {
        int location;
        int distance;

        Node(int location, int distance) {
            this.location = location;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        N = read();
        K = read();

        // N -> K
        System.out.println(hideAndSeek());
    }

    static int hideAndSeek() throws IOException {
        // N이 더 큰 경우 뒤로만 이동한다.
        if (N >= K) {
            return N - K;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(N, 0));

        // 최대 K * 2 위치까지 이동 가능
        boolean[] visited = new boolean[(K * 2) +  1];

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentLocation = currentNode.location;
            if (currentLocation == K) {
                return currentNode.distance;
            }

            if (visited[currentLocation]) continue;
            visited[currentLocation] = true;

            int[] nextLocation = {currentLocation - 1, currentLocation + 1, currentLocation * 2};
            for (int i = 0; i < nextLocation.length; i++) {
                int nextDistance = i == 2 ? 0 : 1;

                int nx = nextLocation[i];
                int nd = currentNode.distance + nextDistance;

                if (nx >= 0 && nx <= (K * 2) && !visited[nx]) {
                    queue.offer(new Node(nx, nd));
                }
            }
        }

        return -1;
    }

    static int read() throws IOException {
        int c, n, sign = 1;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        n = c & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n * sign;
    }
}
