import java.util.Scanner;
import CesarCypher.CesarCypher;

public class GoideConsoleApp {

    private static CesarCypher cesarCypher = new CesarCypher();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        defineMode();
        endApp();
    }

    private static void defineMode(){
        System.out.println("Select code or decode");
        String mode = scanner.nextLine();
        if(mode.equals("d")){
            decypherText();
        }
        else{
            cypherText();
        }
    }

    private static void cypherText(){
        System.out.println("Type the text to be cyphered");
        String input = scanner.nextLine();

        String output = cesarCypher.cypherText(input);
        System.out.println("Cyphered Text: " + output);
    }

    private static void decypherText(){
        System.out.println("Type the text to be decyphered");
        String input = scanner.nextLine();

        String output = cesarCypher.decypherText(input);
        System.out.println("Decyphered Text: " + output);
    }

    private static void endApp(){
        System.out.println("Program finished execution");
        scanner.nextLine();

        System.exit(0);
    }

}
