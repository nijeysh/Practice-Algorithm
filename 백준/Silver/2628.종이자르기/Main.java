import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        // 최대 100
        int h = read(); // 가로
        int v = read(); // 세로

        int n = read();

        // 가로로 자르는 리스트
        ArrayList<Integer> hl = new ArrayList<>();
        hl.add(0);
        hl.add(v);

        // 세로로 자르는 리스트
        ArrayList<Integer> vl = new ArrayList<>();
        vl.add(0);
        vl.add(h);

        for (int i = 0; i < n; i++) {
            int type = read();
            int line = read();
            if (type == 0) {
                // 가로로 자른다.
                hl.add(line);
            } else {
                // 세로로 자른다.
                vl.add(line);
            }
        }

        Collections.sort(hl);
        Collections.sort(vl);

        // System.out.println(hl);
        // System.out.println(vl);

        int max = 0;
        for (int i = 1; i < hl.size(); i++) {
            int currentH = hl.get(i);
            int prevH = hl.get(i-1);
            // 현재 - 이전 사이즈 빼기
            int vWid = currentH - prevH; // 세로 높이
            for (int j = 1; j < vl.size(); j++) {
                int currentV = vl.get(j);
                int prevV = vl.get(j-1);
                // 현재 - 이전 사이즈 빼기
                int hWid = currentV - prevV;

                max = Math.max(max, vWid * hWid);
            }
        }

        System.out.println(max);
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