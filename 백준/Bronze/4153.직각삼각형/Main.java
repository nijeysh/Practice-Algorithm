import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력용 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String line = br.readLine();
            String[] parts = line.split(" ");

            int[] sides = new int[3];
            sides[0] = Integer.parseInt(parts[0]);
            sides[1] = Integer.parseInt(parts[1]);
            sides[2] = Integer.parseInt(parts[2]);

            // 종료 조건
            if (sides[0] == 0 && sides[1] == 0 && sides[2] == 0) {
                break;
            }

            // 정렬 후 직각삼각형 조건 확인
            Arrays.sort(sides);

            if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2]) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }

        // 출력 버퍼 비우기 및 닫기
        bw.flush();
        bw.close();
        br.close();
    }
}
