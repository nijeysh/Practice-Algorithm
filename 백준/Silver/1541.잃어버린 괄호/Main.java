import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    /**
     * 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
     * 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
     * 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
     */
    public static void main(String[] args) throws Exception {
//        System.out.println(8 + 5 -(4 + 5));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int result = 0;
        int number = 0;
        int sign = 1;
        // 9-99-10+10
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '-') {
                // -면 - 로 계속 두기
                // -인데 뒤에 +가 오면 -로 묶어서 처리
                result += (sign * number);
                number = 0;
                sign = -1;
            }
            else if (ch == '+') {
                result += (sign * number);
                number = 0;
            }
            else {
                number *= 10;
                number += (ch - '0');
            }
        }
        result += sign * number;
        System.out.println(result);
    }
}
