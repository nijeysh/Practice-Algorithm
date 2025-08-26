import java.util.*;
import java.io.*;

public class Main {

    // 상하좌우 이동을 위한 방향 배열
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    // BFS를 위한 위치 클래스
    static class Position {
        int x, y, distance;

        Position(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCases; t++) {
            String[] dimensions = br.readLine().split(" ");
            int R = Integer.parseInt(dimensions[0]);
            int C = Integer.parseInt(dimensions[1]);

            char[][] maze = new char[R][C];
            int startX = -1, startY = -1;

            // 미로 입력 및 시작점 찾기
            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                for (int j = 0; j < C; j++) {
                    maze[i][j] = line.charAt(j);
                    if (maze[i][j] == 'S') {
                        startX = i;
                        startY = j;
                    }
                }
            }

            int shortestPath = findShortestPath(maze, R, C, startX, startY);

            if (shortestPath == -1) {
                System.out.println("No Exit");
            } else {
                System.out.println("Shortest Path: " + shortestPath);
            }
        }
    }

    private static int findShortestPath(char[][] maze, int R, int C, int startX, int startY) {
        boolean[][] visited = new boolean[R][C];
        Queue<Position> queue = new LinkedList<>();

        // 시작점을 큐에 추가
        queue.offer(new Position(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int x = current.x;
            int y = current.y;
            int distance = current.distance;

            // 목표지점(G)에 도달했는지 확인
            if (maze[x][y] == 'G') {
                return distance;
            }

            // 상하좌우로 이동 시도
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 경계 체크
                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                // 벽(X)이거나 이미 방문한 곳이면 건너뛰기
                if (maze[nx][ny] == 'X' || visited[nx][ny]) {
                    continue;
                }

                // 방문 표시하고 큐에 추가
                visited[nx][ny] = true;
                queue.offer(new Position(nx, ny, distance + 1));
            }
        }

        // 목표지점에 도달할 수 없는 경우
        return -1;
    }
}