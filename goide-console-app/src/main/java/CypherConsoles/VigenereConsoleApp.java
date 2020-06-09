package CypherConsoles;

import MainCyphers.VigenereCypher;
import Utils.ConsoleStrings;

import java.util.Scanner;

public class VigenereConsoleApp {

    private Scanner scanner;
    private VigenereCypher vigenereCypher = new VigenereCypher();

    public VigenereConsoleApp(Scanner scanner){
        this.setScanner(scanner);
    }

    public void run(){
        defineMode();
    }

    private void defineMode(){
        int mode = 0;
        System.out.println(ConsoleStrings.SELECT_CYPHER_OR_DECYPHER);
        do{
            mode = Integer.parseInt(this.scanner.nextLine());
            if(mode == 1){
                String rotationFactor = getRotationFactor();
                cypherText(rotationFactor);
            }
            else if(mode == 2){
                String rotationFactor = getRotationFactor();
                decypherText(rotationFactor);
            }
            else{
                System.out.println(ConsoleStrings.TRY_AGAIN);
            }
        }while(mode < 1 && mode > 3);
    }

    private String getRotationFactor(){
        String rotationFactor = "";
        System.out.println(ConsoleStrings.TYPE_KEY);
        rotationFactor = this.scanner.nextLine();
        return rotationFactor;
    }


    private void cypherText(String rotationFactor){
        System.out.println(ConsoleStrings.TYPE_TEXT);
        String input = this.scanner.nextLine();

        String output = vigenereCypher.cypherText(input, rotationFactor);
        System.out.println(ConsoleStrings.CYPHERED_TEXT + output);
    }

    private void decypherText(String rotationFactor){
        System.out.println(ConsoleStrings.TYPE_TEXT);
        String input = this.scanner.nextLine();

        String output = vigenereCypher.decypherText(input, rotationFactor);
        System.out.println(ConsoleStrings.DECYPHERED_TEXT + output);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
