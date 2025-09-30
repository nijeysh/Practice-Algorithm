import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int limit = Integer.parseInt(br.readLine().trim());
        int speed = Integer.parseInt(br.readLine().trim());

        if (speed <= limit) {
            System.out.println("Congratulations, you are within the speed limit!");
        } else {
            int over = speed - limit;
            int fine;
            if (over <= 20) fine = 100;
            else if (over <= 30) fine = 270;
            else fine = 500;

            System.out.println("You are speeding and your fine is $" + fine + ".");
        }
    }
}