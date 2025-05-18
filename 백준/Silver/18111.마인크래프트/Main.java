import java.util.Arrays;

public class Main {
    static int N;
    static int M;
    static int B;

    static int max;
    static int min;
    static int[] heights;

    public static void main(String[] args) throws Exception {
        // 1. 좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다. (2초)
        // 2. 인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다. (1초)

        N = read(); // 세로
        M = read(); // 가로
        B = read(); // 인벤토리에 있는 블록

        heights = new int[257];
        max = 0;
        min = 256;
        for (int i = 0; i < N * M; i++) {
            int h = read();
            heights[h]++;   // 특정 높이에 해당하는 개수 카운팅
            max = Math.max(max, h);
            min = Math.min(min, h);
        }

        int minT = Integer.MAX_VALUE;
        int minH = Integer.MAX_VALUE;

        // 높이가 가장 큰 것부터
        for (int height = max; height >= min; height--) {
            int time = 0;
            int inventory = B;
            for (int current = max; current >= min; current--) {
                int needH = height - current;  // 필요한 높이
                int count = heights[current];

                if (needH > 0) {
                    // 인벤에 있는 블록을 꺼내서 쌓는다. (1초)
                    time += needH * count;
                    inventory -= needH * count;
                } else {
                    // 블록을 제거해서 인벤에 넣는다. (2초)
                    needH = Math.abs(needH);
                    time += (2 * needH * count);
                    inventory += needH * count;
                }
            }

            if (inventory >= 0) {
                if (minT > time) {
                    minT = time;
                    minH = height;
                }
            }
        }

        System.out.println(minT + " " + minH);
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