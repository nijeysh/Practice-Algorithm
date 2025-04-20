import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        // 정렬 기준
        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }

        @Override
        public String toString() {
            return "start: " + this.start + ", end: " + this.end + "\n";
        }
    }
    public static void main(String[] args) throws Exception {
        int N = read();
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = read();
            int end = read();
            meetings.add(new Meeting(start, end));
        }

        // 정렬
        Collections.sort(meetings);

        int count = 0;
        int endTime = 0;
        for (Meeting m : meetings) {
            if (m.start >= endTime) {
                count++;
                endTime = m.end;
            }
        }
        System.out.println(count);
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
