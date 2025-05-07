import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]); // 호텔의 층 수
            int W = Integer.parseInt(input[1]); // 각 층의 방 수 (사용하지 않음)
            int N = Integer.parseInt(input[2]); // N번째 손님

            int floor = (N % H == 0) ? H : N % H;
            int room = (N - 1) / H + 1;

            bw.write(floor * 100 + room + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
