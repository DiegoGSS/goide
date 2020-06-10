package CypherConsoles;

import MainCyphers.VigenereCypher;
import Utils.ConsoleStrings;

import java.util.Scanner;

public class VigenereConsoleApp {

    private Scanner scanner;
    private BasicConsoleApp basicConsoleApp;
    private VigenereCypher vigenereCypher = new VigenereCypher();

    public VigenereConsoleApp(Scanner scanner){
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
                String rotationFactor = getRotationFactor();
                cypherText(rotationFactor);
            }
            else if(mode == 2){
                String rotationFactor = getRotationFactor();
                decypherText(rotationFactor);
            }
            else if(mode == 3){
                String rotationFactor = getRotationFactor();
                cypherTextFile(rotationFactor);
            }
            else if(mode == 4){
                String rotationFactor = getRotationFactor();
                decypherTextFile(rotationFactor);
            }
            else{
                System.out.println(ConsoleStrings.TRY_AGAIN);
            }
        }while(mode < 1 && mode > 5);
    }

    private String getRotationFactor(){
        String rotationFactor = "";
        System.out.println(ConsoleStrings.TYPE_KEY);
        rotationFactor = this.scanner.nextLine();
        return rotationFactor;
    }


    private void cypherText(String rotationFactor){
        String input = this.basicConsoleApp.getInputText();

        String output = vigenereCypher.cypherText(input, rotationFactor);

        this.basicConsoleApp.printCypherResults(output);
    }

    private void decypherText(String rotationFactor){
        String input = this.basicConsoleApp.getInputText();

        String output = vigenereCypher.decypherText(input, rotationFactor);

        this.basicConsoleApp.printDecypherResults(output);
    }

    private void cypherTextFile(String rotationFactor){
        String input = this.basicConsoleApp.getInputTextFromFile();

        String output = vigenereCypher.cypherText(input, rotationFactor);

        String filePath = "C:\\repositorio\\goide\\text-files\\vigenerecifrado.txt";
        this.basicConsoleApp.printResultsFile(filePath, output);
    }

    private void decypherTextFile(String rotationFactor){
        String input = this.basicConsoleApp.getInputTextFromFile();

        String output = vigenereCypher.decypherText(input, rotationFactor);

        String filePath = "C:\\repositorio\\goide\\text-files\\vigeneredecifrado.txt";
        this.basicConsoleApp.printResultsFile(filePath, output);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
