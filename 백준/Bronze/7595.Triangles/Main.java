public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        int count;
        while ((count = read()) != 0) {
             for (int i = 1; i <= count; i++) {
                sb.append(star(i)).append("\n");
             }
        }

         System.out.print(sb);
    }

    static String star(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("*");
        }
        return sb.toString();
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

