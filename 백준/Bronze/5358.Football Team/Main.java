import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // i -> e
        // e -> i
        // I -> E
        // E -> I
        String line;
        while ((line = br.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                char r = line.charAt(i);
                switch (r) {
                    case 'i': {
                        r = 'e';
                        break;
                    }
                    case 'e': {
                        r = 'i';
                        break;
                    }
                    case 'I': {
                        r = 'E';
                        break;
                    }
                    case 'E': {
                        r = 'I';
                        break;
                    }
                }
                sb.append(r);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}