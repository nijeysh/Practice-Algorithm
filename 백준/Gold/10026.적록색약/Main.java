import java.io.*;
import java.util.*;
public class Main {

    static int N;
    static char arr[][];
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        // 일반
        int cnt1 = 0;
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                if(!visited[x][y]) {
                    bfs(x,y);
                    cnt1++;
                }
            }
        }

        // 방문 초기화
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }
            }
        }

        // 적록색약
        int cnt2 = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]) {
                    cnt2++;
                    bfs(i, j);
                }
            }
        }

        System.out.println(cnt1 + " " + cnt2);
    }

    public static void bfs(int x, int y) {
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
                // 방문여부, 동일한 값인지 확인
                if (!visited[nx][ny] && (arr[x][y] == arr[nx][ny])) {
                    visited[nx][ny] = true;
                    bfs(nx, ny);
                }
            }
        }
    }
}
