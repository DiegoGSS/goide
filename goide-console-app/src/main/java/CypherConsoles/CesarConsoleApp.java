package CypherConsoles;

import MainCyphers.CesarCypher;
import Utils.ConsoleStrings;

import java.util.Scanner;

public class CesarConsoleApp {

    private Scanner scanner;
    private BasicConsoleApp basicConsoleApp;
    private CesarCypher cesarCypher = new CesarCypher();

    public CesarConsoleApp(Scanner scanner){
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
                cypherText();
            }
            else if(mode == 2){
                decypherText();
            }
            if(mode == 3){
                cypherTextFile();
            }
            else if(mode == 4){
                decypherTextFile();
            }
            else{
                System.out.println(ConsoleStrings.TRY_AGAIN);
            }
        }while(mode < 1 && mode > 5);
    }

    private void cypherText(){
        String input = this.basicConsoleApp.getInputText();

        String output = cesarCypher.cypherText(input);

        this.basicConsoleApp.printCypherResults(output);
    }

    private void decypherText(){
        String input = this.basicConsoleApp.getInputText();

        String output = cesarCypher.decypherText(input);

        this.basicConsoleApp.printDecypherResults(output);
    }

    private void cypherTextFile(){
        String input = this.basicConsoleApp.getInputTextFromFile();

        String output = cesarCypher.cypherText(input);

        String filePath = "C:\\repositorio\\goide\\text-files\\cesarcifrado.txt";
        this.basicConsoleApp.printResultsFile(filePath, output);
    }

    private void decypherTextFile(){
        String input = this.basicConsoleApp.getInputTextFromFile();

        String output = cesarCypher.decypherText(input);

        String filePath = "C:\\repositorio\\goide\\text-files\\cesardecifrado.txt";
        this.basicConsoleApp.printResultsFile(filePath, output);
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
