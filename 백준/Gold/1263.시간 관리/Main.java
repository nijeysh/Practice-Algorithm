import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    static class Work {
        int time;
        int deadline;
        Work(int time, int deadline) {
            this.time = time;
            this.deadline = deadline;
        }

        // @Override
        // public String toString() {
        //     return "(" + this.time + ", " + this.deadline + ")";
        // }
    }

    public static void main(String[] args) throws Exception {
        int N = read(); // 할일 N개

        ArrayList<Work> list = new ArrayList();
        for (int i = 1; i <= N; i++) {
            int t = read(); // 걸리는 시간
            int s = read(); // 마감시간

            list.add(new Work(t, s));
        }

        list.sort(Comparator.comparingInt(w -> w.deadline));
        // Collections.sort(list, Comparator.comparingInt(w -> w.deadline));
        // System.out.println(list);

        // 최대한 늦잠
        // 0시 기준으로 시작해서 남는 시간의 최소값이 가장 늦게잘수있는 시간임
        // + 전부 다 끝낼 수 있어야함
        int current = 0;    // 현재시간
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            Work work = list.get(i);
            // System.out.println(work);

            // 마감시간이랑 실제로 끝낸 시간이랑 비교
            current += work.time;
            min = Math.min(min, work.deadline - current);
        }

        System.out.println(min < 0 ? -1 : min);
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