package CypherConsoles;

import MainCyphers.RotCypher;
import Utils.ConsoleStrings;

import java.util.Scanner;

public class RotConsoleApp {

    private Scanner scanner;
    private RotCypher rotCypher = new RotCypher();

    public RotConsoleApp(Scanner scanner){
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
                int rotationFactor = getRotationFactor();
                cypherText(rotationFactor);
            }
            else if(mode == 2){
                int rotationFactor = getRotationFactor();
                decypherText(rotationFactor);
            }
            else{
                System.out.println(ConsoleStrings.TRY_AGAIN);
            }
        }while(mode < 1 && mode > 3);
    }

    private int getRotationFactor(){
        int rotationFactor = 0;
        System.out.println(ConsoleStrings.TYPE_ROTATION_FACTOR);
        rotationFactor = Integer.parseInt(this.scanner.nextLine());
        return rotationFactor;
    }


    private void cypherText(int rotationFactor){
        System.out.println(ConsoleStrings.TYPE_TEXT);
        String input = this.scanner.nextLine();

        String output = rotCypher.cypherText(input, rotationFactor + 'a');
        System.out.println(ConsoleStrings.CYPHERED_TEXT + output);
    }

    private void decypherText(int rotationFactor){
        System.out.println(ConsoleStrings.TYPE_TEXT);
        String input = this.scanner.nextLine();

        String output = rotCypher.decypherText(input, rotationFactor + 'a');
        System.out.println(ConsoleStrings.DECYPHERED_TEXT + output);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
