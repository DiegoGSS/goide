package CypherConsoles;

import MainCyphers.CesarCypher;
import Utils.ConsoleStrings;

import java.util.Scanner;

public class CesarConsoleApp {

    private Scanner scanner;
    private CesarCypher cesarCypher = new CesarCypher();

    public CesarConsoleApp(Scanner scanner){
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
                cypherText();
            }
            else if(mode == 2){
                decypherText();
            }
            else{
                System.out.println(ConsoleStrings.TRY_AGAIN);
            }
        }while(mode < 1 && mode > 3);
    }

    private void cypherText(){
        System.out.println(ConsoleStrings.TYPE_TEXT);
        String input = this.scanner.nextLine();

        String output = cesarCypher.cypherText(input);
        System.out.println(ConsoleStrings.CYPHERED_TEXT + output);
    }

    private void decypherText(){
        System.out.println(ConsoleStrings.TYPE_TEXT);
        String input = this.scanner.nextLine();

        String output = cesarCypher.decypherText(input);
        System.out.println(ConsoleStrings.DECYPHERED_TEXT + output);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
