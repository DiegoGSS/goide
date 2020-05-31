import java.util.Scanner;
import CesarCypher.CesarCypher;

public class GoideConsoleApp {

    private static CesarCypher cesarCypher = new CesarCypher();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Type the text to be cyphered");
        String input = scanner.nextLine();

        String output = cesarCypher.cypherText(input);
        System.out.println("Cyphered Text: " + output);

        scanner.nextLine();

        System.exit(0);
    }

}
