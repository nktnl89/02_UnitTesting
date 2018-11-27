import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator();

        System.out.print("Введите выражение:");
        try {
            System.out.println(calculator.getResult(bufferedReader.readLine()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
