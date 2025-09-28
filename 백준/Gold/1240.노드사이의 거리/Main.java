import java.util.ArrayList;

public class Main {
    static class Node {
        int node;
        int distance;
        Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            int a = read();
            int b = read();
            int d = read();

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int start = read();
            int end = read();

            visited = new boolean[N+1];
            int answer = dfs(start, end, 0);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static int dfs(int current, int end, int distance) {
        if (current == end) {
            return distance;
        }

        visited[current] = true;
        for (Node next : graph[current]) {
            if (!visited[next.node]) {
                int result = dfs(next.node, end, distance+next.distance);
                if (result != -1) {
                    return result;
                }
            }
        }

        return -1;
    }

    static int read() throws Exception {
        int c, n = 0, sign = 1;
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

// bfs 버전
/*
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int node;
        int distance;
        Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            int a = read();
            int b = read();
            int d = read();

            graph[a].add(new Node(b, d));
            graph[b].add(new Node(a, d));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int start = read();
            int end = read();

            int answer = bfs(start, end, N);
            sb.append(answer).append("\n");
        }

        System.out.print(sb);
    }

    static int bfs(int start, int end, int N) {
        boolean[] visited = new boolean[N+1];
        Queue<Node> queue = new ArrayDeque<>();

        queue.offer(new Node(start, 0));
        visited[start] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.node == end) {
                return current.distance;
            }

            for (Node next : graph[current.node]) {
                if (!visited[next.node]) {
                    visited[next.node] = true;
                    queue.offer(new Node(next.node, current.distance + next.distance));
                }
            }
        }

        return -1;
    }

    static int read() throws Exception {
        int c, n = 0, sign = 1;
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
}*/
