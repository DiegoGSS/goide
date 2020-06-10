package CypherConsoles;

import MainCyphers.RotCypher;
import Utils.ConsoleStrings;

import java.util.Scanner;

public class RotConsoleApp {

    private Scanner scanner;
    private BasicConsoleApp basicConsoleApp;
    private RotCypher rotCypher = new RotCypher();

    public RotConsoleApp(Scanner scanner){

        this.basicConsoleApp = new BasicConsoleApp(scanner);
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
            else if(mode == 3){
                int rotationFactor = getRotationFactor();
                cypherTextFile(rotationFactor);
            }
            else if(mode == 4){
                int rotationFactor = getRotationFactor();
                decypherTextFile(rotationFactor);
            }
            else{
                System.out.println(ConsoleStrings.TRY_AGAIN);
            }
        }while(mode < 1 && mode > 5);
    }

    private int getRotationFactor(){
        int rotationFactor = 0;
        System.out.println(ConsoleStrings.TYPE_ROTATION_FACTOR);
        rotationFactor = Integer.parseInt(this.scanner.nextLine());
        return rotationFactor;
    }


    private void cypherText(int rotationFactor){
        String input = this.basicConsoleApp.getInputText();

        String output = rotCypher.cypherText(input, rotationFactor + 'a');

        this.basicConsoleApp.printCypherResults(output);
    }

    private void decypherText(int rotationFactor){
        String input = this.basicConsoleApp.getInputText();

        String output = rotCypher.decypherText(input, rotationFactor + 'a');

        this.basicConsoleApp.printDecypherResults(output);
    }

    private void cypherTextFile(int rotationFactor){
        String input = this.basicConsoleApp.getInputTextFromFile();

        String output = rotCypher.cypherText(input, rotationFactor + 'a');

        String filePath = "C:\\repositorio\\goide\\text-files\\rotcifrado.txt";
        this.basicConsoleApp.printResultsFile(filePath, output);
    }

    private void decypherTextFile(int rotationFactor){
        String input = this.basicConsoleApp.getInputTextFromFile();

        String output = rotCypher.decypherText(input, rotationFactor + 'a');

        String filePath = "C:\\repositorio\\goide\\text-files\\rotdecifrado.txt";
        this.basicConsoleApp.printResultsFile(filePath, output);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
