import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[3];
        arr[0] = read();
        arr[1] = read();
        arr[2] = read();

        Arrays.sort(arr);
        System.out.print(arr[1]);
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